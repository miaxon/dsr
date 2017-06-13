package com.example.alexcon.dsrclient.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alexcon on 13.06.17.
 */

public class ResponseBase {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.status = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
