package com.example.wakeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class IndexController {

    @FXML private TextField startLocation;
    @FXML private TextField destinationLocation;
    @FXML private TextField arrivalTime;

    @FXML
    private void handleButtonBerechnen(ActionEvent event) {
        String[] startAddress = startLocation.getText().split(",");
        String[] destAddress = destinationLocation.getText().split(",");

        JSONObject startLocationJSON = new JSONObject();
        startLocationJSON.put("address", startAddress[0]);
        startLocationJSON.put("city", "Berlin");
        startLocationJSON.put("postalcode", startAddress[1]);

        JSONObject destinationLocationJSON = new JSONObject();
        destinationLocationJSON.put("address", destAddress[0]);
        destinationLocationJSON.put("city", "Berlin");
        destinationLocationJSON.put("postalcode", destAddress[1]);

        JSONObject endJSON = new JSONObject();
        endJSON.put("from", startLocationJSON);
        endJSON.put("to", destinationLocationJSON);

        getTripTimeFromAPI(endJSON);

    }

    private void getTripTimeFromAPI(JSONObject endJSON) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://wakeapp.saaltofreak.de/api/searchAddress");

            StringEntity stringEntity = new StringEntity(endJSON.toString());
            httpPost.setEntity(stringEntity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-Type", "application/json");

            // Create a custom resonse handler
            ResponseHandler< String > responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    System.out.println(response.getStatusLine().getReasonPhrase());
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpClient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}