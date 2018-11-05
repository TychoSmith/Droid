package com.example.tycho.pickapick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.loopj.android.http.*;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.*;


public class coinTicker extends AppCompatActivity {

    private final String BASE_URL = "https://apiv2.bitcoinaverage.com/indices/global/ticker/BTC";

    TextView mPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cointicker);

        mPriceTextView = (TextView) findViewById(R.id.priceLabel);
        Spinner spinner = (Spinner) findViewById(R.id.currency_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String finalUrl = BASE_URL + parent.getItemAtPosition(position);
                getCoinPrice(finalUrl);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("bitcoin", "nothing happened");
            }
        });
    }


    private void getCoinPrice(String url) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
                Log.d("Bitcoin", "JSON: " + response.toString());

                try {
                    String price = response.getString("last");
                    mPriceTextView.setText(price);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d("Bitcoin", "Request failed Status code: " + statusCode);
                Log.d("Bitcoin", "Failure response: " + response);
                Log.e("ERROR", e.toString());
            }
        });


    }


}
