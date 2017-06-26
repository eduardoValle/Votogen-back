package org.develop.votogen.service;

import org.develop.votogen.model.passport.facebook.FacebookAccessException;
import org.develop.votogen.model.passport.facebook.FacebookConfiguration;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service
public class FacebookService {

    @Autowired
    private FacebookConfiguration config;

    public String getLoginRedirectURL() {
        return config.getLoginRedirectURL();
    }

    public String getAccessToken(String authCode) {
        try {
            String retorno = readURL(new URL(config.getAuthURL(authCode)));
            JSONObject retorno_json = new JSONObject( retorno );
            String access_token = retorno_json.get("access_token").toString();
            System.out.println(retorno);
            if( access_token.isEmpty()  ) {
                throw new FacebookAccessException("Resposta auth inesperada.");
            }else{
                return access_token;
            }
            //throw new FacebookAccessException("Access Token nao retornado");
        } catch (IOException e) {
            throw new FacebookAccessException(e.getMessage());
        }
    }

    public JSONObject getUserFields(String accessToken, String... fields) {
        try {
            JSONObject obj = new JSONObject(readURL(new URL(config.getMeUrl(accessToken, fields))));
            obj.put("accessToken", accessToken);
            return obj;
        } catch (JSONException | IOException e) {
            throw new FacebookAccessException(e.getMessage());
        }
    }

    private String readURL(URL url) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = url.openStream();
        int r;
        while ((r = is.read()) != -1) {
            baos.write(r);
        }
        return new String(baos.toByteArray());
    }

    public JSONObject getUserFieldsByAuthCode(String authCode, String... fields) {

        String accessToken = getAccessToken(authCode);
        JSONObject obj = getUserFields(accessToken, fields);
        try {
            obj.put("accessToken", accessToken);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return obj;
    }
}
