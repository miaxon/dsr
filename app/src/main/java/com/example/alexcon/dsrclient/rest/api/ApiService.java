package com.example.alexcon.dsrclient.rest.api;

/**
 * Created by alexcon on 13.06.17.
 */
import com.example.alexcon.dsrclient.rest.request.AuthRequest;
import com.example.alexcon.dsrclient.rest.response.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface ApiService {
    @POST("/auth")
    Call<AuthResponse> auth(@Body AuthRequest data);
}
