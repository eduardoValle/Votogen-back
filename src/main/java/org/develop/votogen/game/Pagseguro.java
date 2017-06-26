package org.develop.votogen.game;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.JAXB;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * Created by Luiz Eduardo on 05/06/2017.
 */

public class Pagseguro {

    private static String email = "luizeduardovalle@gmail.com";

    private static String token = "5F83764CF7804C669590DB253E3AC3F9";   // sandbox
//    private static String token = "7AF2C750694D4FB0A8707168E62583A4";   // pagseguro

    private static String urlCheckout = "https://ws.sandbox.pagseguro.uol.com.br/v2/checkout";  // sandbox
//    private static String urlCheckout = "https://ws.pagseguro.uol.com.br/v2/checkout";        // pagseguro

    private static String urlNotification = "https://ws.sandbox.pagseguro.uol.com.br/v3/transactions/notifications/";   // sandbox
//    private static String urlNotification = "https://ws.pagseguro.uol.com.br/v3/transactions/notifications/";         // pagseguro


    public static PagseguroResponse comparVida(int numLifes, String lifesValue, int lastInsertId) {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(urlCheckout);
        try {
            ArrayList<NameValuePair> valores = new ArrayList<>();
            valores.add(new BasicNameValuePair("token", token));
            valores.add(new BasicNameValuePair("email", email));
            valores.add(new BasicNameValuePair("currency", "'BRL'"));
            valores.add(new BasicNameValuePair("itemId1", "1"));
            valores.add(new BasicNameValuePair("itemQuantity1", "1"));
            valores.add(new BasicNameValuePair("itemDescription1", "Guru da Sabedoria - " + numLifes + " vidas"));
            valores.add(new BasicNameValuePair("itemAmount1", lifesValue));
            valores.add(new BasicNameValuePair("reference", String.valueOf(lastInsertId)));

            httppost.setEntity( new UrlEncodedFormEntity( valores ) );
            HttpResponse response = httpclient.execute( httppost );
            HttpEntity entity = response.getEntity();

            String xmlResponse = EntityUtils.toString(entity);
            return xmlToString(xmlResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httppost.releaseConnection();
        }
        return new PagseguroResponse();
    }

    public static NotificationResponse pegaStatusPagamento(String notificationCode) {

        String url = urlNotification + notificationCode + "?email=" + email + "&token=" + token;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line;

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return xmlToNotificationResponse(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new NotificationResponse();
    }

    private static NotificationResponse xmlToNotificationResponse(String xml) {
        return JAXB.unmarshal(new StringReader(xml), NotificationResponse.class);
    }

    private static PagseguroResponse xmlToString(String xml){
       return JAXB.unmarshal(new StringReader(xml), PagseguroResponse.class);
    }
}