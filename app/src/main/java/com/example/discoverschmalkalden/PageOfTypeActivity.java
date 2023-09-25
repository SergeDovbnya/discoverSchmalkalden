package com.example.discoverschmalkalden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class PageOfTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_of_type);

        ImageView hikingBackground = findViewById(R.id.hiking_background);

        ImageView hikinglogo = findViewById(R.id.hikingLogo);

        RecyclerView placeRV = findViewById(R.id.idRVPlace);

        // Here, we have created new array list and added data to it
        ArrayList<PlaceModel> placeModelArrayList = new ArrayList<PlaceModel>();
        placeModelArrayList.add(new PlaceModel("Rhönblick", 7, R.drawable.rhoen_ks));
        placeModelArrayList.add(new PlaceModel("Brotterode-Trusetal", 14, R.drawable.trusetalerwasserfall));
        placeModelArrayList.add(new PlaceModel("Floh-Seligenthal", 6, R.drawable.floh_seligenthal));
        placeModelArrayList.add(new PlaceModel("Grabfeld", 42, R.drawable.grabfeld));

        // we are initializing our adapter class and passing our arraylist to it.
        PlaceAdapter placeAdapter = new PlaceAdapter(this, placeModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        placeRV.setLayoutManager(linearLayoutManager);
        placeRV.setAdapter(placeAdapter);
    }
}