package com.bridgelabz.ipl.model;

/**
 * Created by bridgeit on 20/1/17.
 */
public class LoginModel {
    String email;
    String pass;

    public LoginModel(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String username) {
        this.pass = username;
    }
}