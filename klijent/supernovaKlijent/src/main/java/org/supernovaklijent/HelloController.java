package org.supernovaklijent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;


public class HelloController {
    @FXML
    public Button loginButton;

    @FXML
    public TextField passwordTextField;

    @FXML
    public Label welcomeText;

    @FXML
    public TextField usernameTextField;

    @FXML
    public Label welcomeText1;

    @FXML
    public void onHelloButtonClick(ActionEvent event) {

        String name = "test ime";
        String pass= "test lozinka";

       name = usernameTextField.getText();
        pass = passwordTextField.getText();

        System.out.println("ime" + name + "  lozinka "+ pass);


        String httpBody = "username="+name+
                "#password="+ pass;

        //provjera da li postoji u bazi#
        ////////////////////////////////////////////////////////////////////////////////////////////////

        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket s = new Socket(address,1030);

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgin="";
            String msgout="";
            while(!msgin.equals("chat.stop()")) {
                System.out.print(">");
                msgout =httpBody;
                dout.writeUTF(msgout);
                if(msgout.equals("chat.stop()"))
                    break;
                msgin = din.readUTF();
                System.out.println("Server: "+msgin);
                if(msgin.equals("chat.stop()"))
                    break;
            }
            s.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


}



