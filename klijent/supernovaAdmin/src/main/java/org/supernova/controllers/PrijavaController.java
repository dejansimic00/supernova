package org.supernova.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PrijavaController {

    @FXML
    public TextField passwordTextField;

    @FXML
    public TextField usernameTextField;

    @FXML
    public void signInButtonClicked(ActionEvent event) {
        String name = "test ime";
        String pass= "test lozinka";

       /* name = usernameTextField.getText();
        pass = usernameTextField.getText();*/

        System.out.println("ime" + name + "  lozinka "+ pass);


        //provjera da li postoji u bazi



        //promjena scene u slucaju


        String endpointUrl = "https://localhost:8080/api/endpoint";
        String jsonInputString = "{\"username\": \"example_user\", \"password\": \"password123\"}";

        try {
            URL url = new URL(endpointUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonInputString.getBytes());
            outputStream.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response;
            while ((response = reader.readLine()) != null) {
                System.out.println(response);
            }
            reader.close();

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
