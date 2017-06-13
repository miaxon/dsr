package com.example.alexcon.dsrclient.rest.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthRequest extends RequestBase {

    @SerializedName("apiver")
    @Expose
    private String apiver;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password")
    @Expose
    private String password;

    public AuthRequest(String apiver, String login, String password){
        this.apiver = apiver;
        this.login = login;
        this.password = password;
    }

    public String getApiver() {
        return apiver;
    }

    public void setApiver(String apiver) {
        this.apiver = apiver;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}