package com.example.alexcon.dsrclient.rest;

/**
 * Created by alexcon on 13.06.17.
 */

public class ErrorEvent {
    private String message;
    public ErrorEvent(String message){this.message = message;}
    public String getMessage(){return this.message;}
}
