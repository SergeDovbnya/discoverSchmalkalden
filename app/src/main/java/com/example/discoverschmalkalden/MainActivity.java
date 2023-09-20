package com.example.discoverschmalkalden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView menuIcon = findViewById(R.id.menuIcon);
        ImageView logoIcon = findViewById(R.id.schmalkaldenLogo);
        ImageView searchIcon = findViewById(R.id.searchIcon);
        ImageButton hikingButton = findViewById(R.id.hikingButton);
        ImageButton events = findViewById(R.id.eventButton);
        ImageButton food = findViewById(R.id.foodButton);


        hikingButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PageOfTypeActivity.class);
            startActivity(intent);
        });
    }
}