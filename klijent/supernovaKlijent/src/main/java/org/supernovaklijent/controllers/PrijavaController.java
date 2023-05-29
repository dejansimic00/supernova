package org.supernovaklijent.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class PrijavaController {

    @FXML
    public TextField passwordTextField;

    @FXML
    public TextField usernameTextField;

    @FXML
    public void signInButtonClicked(ActionEvent event) {


        try {
            String inputText = "login#username=" + usernameTextField.getText() +
                    "#password=" + passwordTextField.getText();

            System.out.println(inputText);


            InetAddress ipAddress = InetAddress.getLocalHost();
            Socket s = new Socket(ipAddress, 1030);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String requestMessage = "";
            String responseMessage = "";


            requestMessage = inputText;
            dout.writeUTF(requestMessage);
            responseMessage = din.readUTF();
            System.out.println("Server: " + responseMessage);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


