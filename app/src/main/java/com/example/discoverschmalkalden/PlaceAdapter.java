package com.example.discoverschmalkalden;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>{
    private final Context context;
    private final ArrayList<PlaceModel> placeModelArrayList;

    // Constructor
    public PlaceAdapter(Context context, ArrayList<PlaceModel> placeModelArrayList) {
        this.context = context;
        this.placeModelArrayList = placeModelArrayList;
    }

    @NonNull
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.ViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        PlaceModel model = placeModelArrayList.get(position);
        holder.placeNameTV.setText(model.getPlace_name());
        holder.placeDistanceTV.setText("" + model.getPlace_distance() + " km away");
        holder.placeIV.setImageResource(model.getPlace_image());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return placeModelArrayList.size();
    }

    // View holder class for initializing of your views such as TextView and Imageview
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView placeIV;
        private final TextView placeNameTV;
        private final TextView placeDistanceTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            placeIV = itemView.findViewById(R.id.placePictureIW);
            placeNameTV = itemView.findViewById(R.id.placeNameTW);
            placeDistanceTV = itemView.findViewById(R.id.distanceAwayTW);
        }
    }
}
