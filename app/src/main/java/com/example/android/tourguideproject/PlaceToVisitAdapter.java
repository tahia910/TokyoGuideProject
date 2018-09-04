package com.example.android.tourguideproject;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * {@link PlaceToVisitAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link PlaceToVisit} objects.
 */
public class PlaceToVisitAdapter extends ArrayAdapter<PlaceToVisit> {


    /**
     * Create a new {@link PlaceToVisitAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param listOfPlaces is the list of {@link PlaceToVisit} to be displayed.
     */
    public PlaceToVisitAdapter(Activity context, ArrayList<PlaceToVisit> listOfPlaces) {
        super(context, 0, listOfPlaces);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link PlaceToVisit} object located at this position in the list
        PlaceToVisit currentPlaceToVisit = getItem(position);

        // Find the TextView in the list_item.xml layout and set the text to the current
        // position's name.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.text_view);
        defaultTextView.setText(currentPlaceToVisit.getPlaceName());

        // Find the ImageView in the list_item.xml layout and set the image to the current
        // position's image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentPlaceToVisit.getImageResourceId());

        // Return the whole list item layout (containing 1 TextView and 1 ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
