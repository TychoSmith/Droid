package com.example.tycho.pickapick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class selector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
    }


    public void startCoinTicker(View v){
        Intent myIntent = new Intent(getBaseContext(), coinTicker.class);
        startActivity(myIntent);
    }
    public void startCamCam(View v){
        Intent myIntent = new Intent(getBaseContext(), camCam.class);
        startActivity(myIntent);
    }
    public void startWeather(View v){
        Intent myIntent = new Intent(getBaseContext(), WeatherController.class);
        startActivity(myIntent);
    }

}
