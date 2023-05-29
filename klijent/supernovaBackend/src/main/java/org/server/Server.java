package org.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1030);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String requestMessage = "";
            String responseMessage = "";
            while(true) {
                Thread.sleep(1000);
                requestMessage = din.readUTF();
                System.out.println(requestMessage+" FROM SERVER");


                 responseMessage =  parseInput(requestMessage);

                dout.writeUTF(responseMessage);
                dout.flush();

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private static String parseInput(String input){
        String[] arr = input.split("#");
        String result = "";
        try{

            String method = arr[0];

            switch (method){
                case "list":{

                    result = userListView();

                    result = "list method valid";
                    return result
                            ;

                } case "create" :{
                    result = "create method valid";
                } case "pay" : {

                } case "updateBalance" :{

                } case "balance" :{

                } case "login" :{

                    result = userListView();

                    result = "login method valid";
                    return result
                            ;

                } default :{

                }


            }

            return result;

        } catch (ArrayIndexOutOfBoundsException arob){
            System.out.println(" Bad Index");
        }

        return "Error 404";
    }

    private static String userListView(){

        return "";
    }

    private static String createUser(String in){

        return "";
    }

    private static String payment( ){

        return "";
    }

    private static String login() {

        return "";
    }

    private static String checkBalance(){

        return "";
    }
}
