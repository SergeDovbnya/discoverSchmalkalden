package com.example.discoverschmalkalden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class PageOfTypeActivity extends AppCompatActivity implements OnItemsClickListener{

    public static final String OBJECT = "object";
    // Need this clickListener for the Main-list item onClick events
    private ArrayList<PlaceModel> filteredArrayList = new ArrayList<>();
    private PlaceType placeType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_of_type);

        ImageView background = findViewById(R.id.hiking_background);
        ImageView logo = findViewById(R.id.hikingLogo);

        int activityType = getIntent().getExtras().getInt("TYPE");
        switch (activityType) {
            case 1:
                background.setImageResource(R.drawable.hiking_background);
                logo.setImageResource(R.drawable.hiking_logo);
                placeType = PlaceType.HIKING;
                break;
            case 2:
                background.setImageResource(R.drawable.events_background);
                logo.setImageResource(R.drawable.events_logo);
                placeType = PlaceType.EVENT;
                break;
            case 3:
                background.setImageResource(R.drawable.food_background);
                logo.setImageResource(R.drawable.food_logo);
                placeType = PlaceType.FOOD;
                break;
        }

        RecyclerView placeRV = findViewById(R.id.idRVPlace);

        // Here, we have created new array list and added data to it
        ArrayList<PlaceModel> placeModelArrayList = createData();

        filteredArrayList.clear();
        for (PlaceModel place: placeModelArrayList) {
            if (placeType != null) {
                if (place.getType() == placeType) {
                    filteredArrayList.add(place);
                }
            }
        }

        // we are initializing our adapter class and passing our arraylist to it.
        PlaceAdapter placeAdapter = new PlaceAdapter(this, filteredArrayList, this);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        placeRV.setLayoutManager(linearLayoutManager);
        placeRV.setAdapter(placeAdapter);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, PlaceDescriptionActivity.class);
        String plName = filteredArrayList.get(position).getPlace_name();
        int plDesc = filteredArrayList.get(position).getPlace_description();
        int plPicture = filteredArrayList.get(position).getPlace_image();
        double plLat = filteredArrayList.get(position).getPlace_lat();
        double plLng = filteredArrayList.get(position).getPlace_lng();
        CustomData cd = new CustomData(plName, plDesc, plPicture, plLat, plLng);
        intent.putExtra(OBJECT, cd);
        startActivity(intent);
    }

    private ArrayList<PlaceModel> createData() {
        ArrayList<PlaceModel> data = new ArrayList<>();
        data.add(new PlaceModel("Rhönblick", PlaceType.HIKING, R.string.description_item1, 50.72695191940359, 10.395809851823534, 7, R.drawable.rhoen_ks));
        data.add(new PlaceModel("Brotterode-Trusetal", PlaceType.HIKING, R.string.description_item2, 50.79946546793923, 10.417242896798642,14, R.drawable.trusetalerwasserfall));
        data.add(new PlaceModel("Floh-Seligenthal", PlaceType.HIKING, R.string.description_item3, 50.78498117628224, 10.532986907890328,6, R.drawable.floh_seligenthal));
        data.add(new PlaceModel("Grabfeld", PlaceType.HIKING, R.string.description_item4, 50.47115024412323, 10.439356658225828,42, R.drawable.grabfeld));
        data.add(new PlaceModel("Maykel's", PlaceType.FOOD, R.string.description_item5, 50.72249543871868, 10.452939997685457, 2, R.drawable.maykels));
        data.add(new PlaceModel("Grünes Tor", PlaceType.FOOD, R.string.description_item6, 50.72389185930175, 10.453009826521074, 2, R.drawable.gruenes_tor));
        data.add(new PlaceModel("Viba Lunch", PlaceType.EVENT, R.string.description_item7, 50.71833419858939, 10.436292982343426, 3, R.drawable.viba_lunch ));
        return data;
    }

}