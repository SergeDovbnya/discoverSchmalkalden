package com.example.discoverschmalkalden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import java.util.ArrayList;

public class PageOfTypeActivity extends AppCompatActivity implements OnItemsClickListener{
    public static final String OBJECT = "object";
    // Need this clickListener for the Main-list item onClick events
    private ArrayList<PlaceModel> placeModelArrayList = new ArrayList<PlaceModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_of_type);
//        setImageResource
        ImageView background = findViewById(R.id.hiking_background);

        ImageView logo = findViewById(R.id.hikingLogo);

        int activityType = getIntent().getExtras().getInt("TYPE");
        switch (activityType) {
            case 1:
                background.setImageResource(R.drawable.hiking_background);
                logo.setImageResource(R.drawable.hiking_logo);
                break;
            case 2:
                background.setImageResource(R.drawable.events_background);
                logo.setImageResource(R.drawable.events_logo);
                break;
            case 3:
                background.setImageResource(R.drawable.food_background);
                logo.setImageResource(R.drawable.food_logo);
                break;
        }

        RecyclerView placeRV = findViewById(R.id.idRVPlace);

        // Here, we have created new array list and added data to it
        placeModelArrayList.add(new PlaceModel("Rhönblick", R.string.description_item1, 7, R.drawable.rhoen_ks));
        placeModelArrayList.add(new PlaceModel("Brotterode-Trusetal", R.string.description_item2, 14, R.drawable.trusetalerwasserfall));
        placeModelArrayList.add(new PlaceModel("Floh-Seligenthal", R.string.description_item3, 6, R.drawable.floh_seligenthal));
        placeModelArrayList.add(new PlaceModel("Grabfeld", R.string.description_item4, 42, R.drawable.grabfeld));

        // we are initializing our adapter class and passing our arraylist to it.
        PlaceAdapter placeAdapter = new PlaceAdapter(this, placeModelArrayList, this);

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
        String plName = placeModelArrayList.get(position).getPlace_name();
        int plDesc = placeModelArrayList.get(position).getPlace_description();
        int plPicture = placeModelArrayList.get(position).getPlace_image();
        CustomData cd = new CustomData(plName, plDesc, plPicture);
        intent.putExtra(OBJECT, cd);
        startActivity(intent);
    }
}