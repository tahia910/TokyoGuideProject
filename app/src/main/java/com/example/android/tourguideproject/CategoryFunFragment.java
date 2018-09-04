package com.example.android.tourguideproject;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays the list for the Fun Category.
 */
public class CategoryFunFragment extends Fragment {

    public CategoryFunFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Create the list for the Fun Category. All texts are stored as Strings.
        final ArrayList<PlaceToVisit> listOfPlaces = new ArrayList<PlaceToVisit>();
        listOfPlaces.add(new PlaceToVisit(getString(R.string.fun_item1_name), R.drawable.odaiba,
                getString(R.string.fun_item1_description),getString(R.string.fun_item1_information)));
        listOfPlaces.add(new PlaceToVisit(getString(R.string.fun_item2_name), R.drawable.hanayashiki,
                getString(R.string.fun_item2_description),getString(R.string.fun_item2_information)));
        listOfPlaces.add(new PlaceToVisit(getString(R.string.fun_item3_name), R.drawable.tokyo_disneyland,
                getString(R.string.fun_item3_description),getString(R.string.fun_item3_information)));
        listOfPlaces.add(new PlaceToVisit(getString(R.string.fun_item4_name), R.drawable.ghibli_museum,
                getString(R.string.fun_item4_description),getString(R.string.fun_item4_information)));
        listOfPlaces.add(new PlaceToVisit(getString(R.string.fun_item5_name), R.drawable.miraikan,
                getString(R.string.fun_item5_description),getString(R.string.fun_item5_information)));
        listOfPlaces.add(new PlaceToVisit(getString(R.string.fun_item6_name), R.drawable.tokyo_dome_city,
                getString(R.string.fun_item6_description),getString(R.string.fun_item6_information)));

        // Create an {@link PlaceToVisitAdapter}, whose data source is a list of {@link PlaceToVisit}s.
        // Then find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        PlaceToVisitAdapter adapter = new PlaceToVisitAdapter(getActivity(), listOfPlaces);
        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link PlaceToVisit} in the list.
        listView.setAdapter(adapter);

        // Sets the action after clicking on each items. Will export the information contained at
        // that position to the PlaceToVisitDetails Activity.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Context context = listView.getContext();
                Intent intent = new Intent(context, PlaceToVisitDetails.class);
                intent.putExtra("placeName", listOfPlaces.get(position).getPlaceName());
                intent.putExtra("placeImage", listOfPlaces.get(position).getImageResourceId());
                intent.putExtra("placeDescription", listOfPlaces.get(position).getPlaceDescription());
                intent.putExtra("placeInformation", listOfPlaces.get(position).getPlaceInformation());
                context.startActivity(intent);
            }
        });
        return rootView;
    }
}
