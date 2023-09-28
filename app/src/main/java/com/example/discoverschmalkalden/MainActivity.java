package com.example.discoverschmalkalden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

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
            intent.putExtra("TYPE",1);
            startActivity(intent);
        });

        events.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, PageOfTypeActivity.class);
            intent2.putExtra("TYPE",2);
            startActivity(intent2);
        });

        food.setOnClickListener(view -> {
            Intent intent3 = new Intent(MainActivity.this, PageOfTypeActivity.class);
            intent3.putExtra("TYPE",3);
            startActivity(intent3);
        });
    }
}