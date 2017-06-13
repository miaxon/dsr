package com.example.alexcon.dsrclient.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alexcon on 13.06.17.
 */

public class AuthResponse extends ResponseBase {
    @SerializedName("ssid")
    @Expose
    private String ssid;

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    @Override
    public String toString() {
        return "AuthResponse {" +
                "ssid='" + ssid + '\'' +
                ", status='" + getStatus() + '\''+
                '}';
    }
}
