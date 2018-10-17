package com.example.tycho.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class coinTracker extends AppCompatActivity {

        TextView mPriceTextView;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPriceTextView = (TextView) findViewById(R.id.priceLabel);

        setContentView(R.layout.activity_coin_tracker);
    }
}
