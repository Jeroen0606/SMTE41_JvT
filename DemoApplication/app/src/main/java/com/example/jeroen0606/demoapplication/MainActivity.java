package com.example.jeroen0606.demoapplication;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnJSON = (Button) findViewById(R.id.button2);

        LocationManager locationManager;
        MyLocListener location;
        location = new MyLocListener();
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0, location);
    }

    public void goToJson(View view) {
        Intent intent = new Intent(this, JSONActivity.class);
        startActivity(intent);
    }
}
