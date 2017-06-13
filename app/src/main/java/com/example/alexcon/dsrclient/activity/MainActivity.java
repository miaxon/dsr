package com.example.alexcon.dsrclient.activity;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


import com.example.alexcon.dsrclient.R;
import com.example.alexcon.dsrclient.rest.ErrorEvent;
import com.example.alexcon.dsrclient.rest.RestApiClient;
import com.example.alexcon.dsrclient.rest.api.ApiService;
import com.example.alexcon.dsrclient.rest.request.AuthRequest;
import com.example.alexcon.dsrclient.rest.response.AuthResponse;

import org.greenrobot.eventbus.*;

public class MainActivity extends AppCompatActivity {

    private ApiService mAPIService;
    private RestApiClient client;
    private AlertDialog.Builder dialog;
    private EventBus eventBus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventBus = EventBus.getDefault();
        eventBus.register(this);
        dialog = new AlertDialog.Builder(this);
        client = new RestApiClient("https://10.0.2.2:9991/");

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                eventBus.post(new AuthRequest("0.13-dev", "admin", "admin"));
            }
        }
        );

    }
    @Subscribe
    public void onError(ErrorEvent event){
        dialog.setMessage("error.\n" + event.getMessage());
        dialog.setPositiveButton("Ok", null);
        dialog.show();
    }
    @Subscribe
    public void onAuth(AuthResponse data){
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("post submitted to API.\n" + data.getSsid());
    }
}
