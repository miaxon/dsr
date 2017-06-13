package com.example.alexcon.dsrclient.rest.api;

/**
 * Created by alexcon on 13.06.17.
 */
import com.example.alexcon.dsrclient.rest.RetrofitClient;
public class ApiUtils {
    private ApiUtils() {}

    //public static String baseUrl = "https://10.0.2.2:9991/";

    public static ApiService getApiService(String baseUrl) {

        return RetrofitClient.getClient(baseUrl).create(ApiService.class);
    }
}
