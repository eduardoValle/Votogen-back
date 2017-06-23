package org.develop.guru.security;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.develop.guru.config.TokenUtils;
import org.develop.guru.entities.Codes;
import org.develop.guru.model.passport.facebook.FacebookConfiguration;
import org.develop.guru.properties.Properties;
import org.develop.guru.repository.CodeRepository;
import org.develop.guru.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    @Autowired
    private CodeRepository codeRepository;

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

    @RequestMapping(value = "checkEmail", method = RequestMethod.POST)
    public ResponseEntity<UserResponse> checkEmail(@RequestBody @Valid CheckEmailRequest request)
            throws ParseException {
        SystemUser user = authenticationService.checkEmail(request.getEmail());
        CodeService codes = new CodeService();
        String codigo = codes.codeService();
        Codes code = authenticationService.registerCodes(user.getId(), codigo, LocalDateTime.now().toString(), LocalDateTime.now().plusDays(1).toString());
        if (user != null) {
            ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
            EmailService mm = (EmailService) context.getBean("mailMail");
            mm.sendMail(user.getName(),
                    user.getEmail(),
                    codigo);
            return ResponseEntity.ok(new UserResponse("Email encontrado!"));
        } else
            return ResponseEntity.badRequest().body(null);

    }

    @RequestMapping(value = "checkCode", method = RequestMethod.POST)
    public ResponseEntity<CodeResponse> checkCode(@RequestBody @Valid CheckCodeRequest request)
            throws ParseException {
        Codes code = authenticationService.checkCode(request.getCodigo());
        if (code != null) {
            return ResponseEntity.ok(new CodeResponse(code.getUserId(),"Codigo encontrado!"));
        } else
            return ResponseEntity.badRequest().body(null);

    }

    @PreAuthorize("isAuthenticated()")
    public SpringUser me() {
        return securityService.getCurrentUser();
    }
}
