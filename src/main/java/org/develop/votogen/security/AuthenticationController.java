package org.develop.votogen.security;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.develop.votogen.config.TokenUtils;
import org.develop.votogen.model.passport.facebook.FacebookConfiguration;
import org.develop.votogen.properties.Properties;
import org.develop.votogen.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private Properties properties;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private FacebookService facebookService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SystemUserRepository systemUserRepo;

    @Autowired
    private FacebookConfiguration config;

    @Autowired
    private TokenUtils tokenUtils;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Response authenticationRequest(@RequestBody @Valid AuthenticationRequest authenticationRequest) {

        System.out.println("LOGIN: ");
        Response response = this.authenticationService.login(authenticationRequest.getEmail(),
                authenticationRequest.getPassword());
        return response;

    }

    @RequestMapping(value = "facebookapp", method = RequestMethod.POST)
    public Response authenticationFacebookappRequest(@RequestBody Facebookapp authenticationFacebookRequest)
            throws JSONException {
        Response r = this.authenticationService.loginFacebook(authenticationFacebookRequest.getEmail());

        return r;
    }

    @RequestMapping(value = "facebook", method = RequestMethod.POST)
    public Response authenticationFacebookRequest(@RequestBody FacebookRequest authenticationFacebookRequest)
            throws JSONException {

        config.setRedirectUri(authenticationFacebookRequest.getRedirectUri());

        JSONObject obj = this.facebookService.getUserFieldsByAuthCode(authenticationFacebookRequest.getCode(), "email");

        Response r = this.authenticationService.loginFacebook(obj.getString("email"));

        return r;
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ResponseEntity<AuthenticationResponse> authenticationRequest(HttpServletRequest request) {
        String refreshedToken = this.authenticationService
                .refresh(request.getHeader(properties.getToken().getHeader()));
        if (refreshedToken != null) {
            return ResponseEntity.ok(new AuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SystemUser user = authenticationService.register(request.getEmail(),
                new String((new BCryptPasswordEncoder().encode(request.getPassword()))), request.getName(),
                sdf.parse(request.getDateNasc()));
        if (user != null) {
            return ResponseEntity.ok(new RegisterResponse("Usuário Cadastrado com sucesso!"));
        } else
            return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public SystemUser getUserSystemUser(@PathVariable("id") Integer id) {

        SystemUser user = systemUserRepo.findById(id).orElseThrow(NotFoundException::new);
        return user;
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public ResponseEntity<RegisterResponse> edit(@RequestBody @Valid EditRequest request) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SystemUser user = authenticationService.edit(request.getEmail(), request.getName(), sdf.parse(request.getDateNasc()));
        if (user != null) {
            return ResponseEntity.ok(new RegisterResponse("Alterações realizadas com sucesso!"));
        } else
            return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(value = "newPassword/{id}", method = RequestMethod.POST)
    public ResponseEntity<RegisterResponse> newPassword(@RequestBody @Valid UserRequest request, @PathVariable("id") Integer id) throws ParseException {
        System.out.println(id);
        SystemUser user = authenticationService.newPassword(id, request.getPassword());
        if (user != null) {
            return ResponseEntity.ok(new RegisterResponse("Alterações realizadas com sucesso!"));
        } else
            return ResponseEntity.badRequest().body(null);

    }

    @PreAuthorize("isAuthenticated()")
    public SpringUser me() {
        return securityService.getCurrentUser();
    }
}
