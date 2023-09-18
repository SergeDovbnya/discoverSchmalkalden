package com.example.discoverschmalkalden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class PageOfTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_of_type);

        ImageView hikingBackground = findViewById(R.id.hiking_background);

        ImageView hikinglogo = findViewById(R.id.hikingLogo);

        ImageView hikingPlace1 = findViewById(R.id.hikingplace1);
        ImageView hikingPlace2 = findViewById(R.id.hikingPlace2);
    }
}