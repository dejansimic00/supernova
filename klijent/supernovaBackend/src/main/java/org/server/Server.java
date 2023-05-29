package org.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

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

    private static UserDAO userDAO = new UserDAO();

    private static String parseInput(String input){
        String[] arr = input.split("#");
        String result = "";
        try{

            String method = arr[0];

            switch (method){
                case "list":{
                    result = userListView();
                    break;
                } case "create" :{
                    result = createUser(arr);
                    break;
                } case "pay" : {
                    result = payment();
                    break;
                } case "updateBalance" :{
                    result = updateBalance(arr);
                    break;
                } case "login" :{
                    result = login(arr);
                } default :{

                }
            }

            return result;

        } catch (ArrayIndexOutOfBoundsException arob){
            System.out.println(" Bad Index");
        }

        return "Error 404";
    }

    private static String userListView()  {
        try {
            List<User> userList = userDAO.getUsers();
            String result="";
            for(User user : userList){
                result+=user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    private static String createUser(String[] in){
        User user = new User(in[1],in[2],in[3],in[4],in[5],in[6],Float.parseFloat(in[7]))
        try {
            userDAO.createUser(user);
            return "Succesfull";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    private static String payment(String[] in ){

        try {
            userDAO.divideAndSubtractBalance(BigDecimal.valueOf(Float.parseFloat(in[1])));
            return "Succesfull";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    private static String login(String[] in) {

        return "";
    }

    private static String checkBalance(String in[]){
       return userDAO.checkBalance(in[1]);
    }
    private static String updateBalance(String[] in){
        try {
            userDAO.updateBalanceByUsername(in[1],BigDecimal.valueOf(Float.parseFloat(in[2])));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
