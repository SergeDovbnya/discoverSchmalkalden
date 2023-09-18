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
        ImageView categoryIcon = findViewById(R.id.categoryIcon);
        ImageButton hikingButton = findViewById(R.id.imageButton);
        ImageView events = findViewById(R.id.eventIconView);
        ImageView food = findViewById(R.id.foodIconView);
        ImageView recommendedPlace = findViewById(R.id.recommendedPlaceIcon);
        ImageView recommendedPlace1 = findViewById(R.id.recommendedPlace1);
        ImageView recommendedPlace2 = findViewById(R.id.recommendedPlace2);
        ImageView recommendedPlace3 = findViewById(R.id.recommendedPlace3);


        hikingButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PageOfTypeActivity.class);
            startActivity(intent);
        });
    }
}