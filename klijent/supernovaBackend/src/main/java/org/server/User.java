package org.server;

import java.math.BigDecimal;

public class User {

    private String name;
    private String surname;
    private String phoneNumber;
    private String username;
    private String password;
    private String mail;
    private double balance;

    public User(String name, String surname, String phoneNumber,
                String username, String password, String mail, float balance) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.balance = balance;
    }


    public User(String name, String surname, String phoneNumber, String username, String mail, double balance) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.mail = mail;
        this.balance = balance;
    }

    @Override
    public String toString(){
        return username + " " + name+ " " + surname+ " " + phoneNumber+ " " + mail+ " " + balance;
    }

    public BigDecimal getBalance() {
        return BigDecimal.valueOf(balance);
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }
}
