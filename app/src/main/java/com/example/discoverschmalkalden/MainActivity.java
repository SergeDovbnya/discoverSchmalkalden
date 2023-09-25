package com.example.discoverschmalkalden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton hikingButton = findViewById(R.id.hikingButton);
        ImageButton events = findViewById(R.id.eventButton);
        ImageButton food = findViewById(R.id.foodButton);

        hikingButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PageOfTypeActivity.class);
            startActivity(intent);
        });

        events.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, PlaceDescription.class);
            startActivity(intent2);
        });
    }
}