package com.example.discoverschmalkalden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
public class HikingActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiking_activity);

        ImageView hikingBackground = findViewById(R.id.hiking_background);

        ImageView hikinglogo = findViewById(R.id.hikingLogo);

        ImageView hikingPlace1 = findViewById(R.id.hikingplace1);
        ImageView hikingPlace2 = findViewById(R.id.hikingPlace2);

    }

}
