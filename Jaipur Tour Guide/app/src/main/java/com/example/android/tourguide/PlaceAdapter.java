package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView placeNameTextView = (TextView) listItemView.findViewById(R.id.place_name);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        placeNameTextView.setText(currentPlace.getName());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView placeDescriptionTextView =
                (TextView) listItemView.findViewById(R.id.place_description);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        placeDescriptionTextView.setText(currentPlace.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView placeImageView = (ImageView) listItemView.findViewById(R.id.place_image);
        // Check if an image is provided for this word or not

        placeImageView.setImageResource(currentPlace.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }

}
