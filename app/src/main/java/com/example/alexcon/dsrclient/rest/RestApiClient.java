package com.example.alexcon.dsrclient.rest;

/**
 * Created by alexcon on 13.06.17.
 */
import android.util.Log;

import com.example.alexcon.dsrclient.rest.api.ApiService;
import com.example.alexcon.dsrclient.rest.api.ApiUtils;
import com.example.alexcon.dsrclient.rest.request.AuthRequest;
import com.example.alexcon.dsrclient.rest.response.AuthResponse;

import org.greenrobot.eventbus.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestApiClient {
    private ApiService apiService;
    private EventBus eventBus;
    public RestApiClient(String baseUrl)
    {
        eventBus = EventBus.getDefault();
        eventBus.register(this);
        apiService = ApiUtils.getApiService(baseUrl);
    }
    @Subscribe
    public void Auth(AuthRequest data)
    {
        apiService.auth(data).enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {

                if(response.isSuccessful()) {
                    Log.i("", "post submitted to API." + response.body().toString());
                    eventBus.post(response.body());
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                eventBus.post(new ErrorEvent(t.getLocalizedMessage()));
            }
        });
    }
}
