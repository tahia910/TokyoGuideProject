package com.example.android.tourguideproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * {@link PlaceToVisitDetails} is the activity for the page displaying the details of each item
 * from the list of {@link PlaceToVisit} objects.
 */
public class PlaceToVisitDetails extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the item_details.xml layout file
        setContentView(R.layout.item_details);

        // Set up the toolbar, to prepare for the Collapsing effect.
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Receive the intents that were sent from the selected item previously from the list of
        // {@link PlaceToVisit} objects.
        Intent intent = getIntent();
        String placeName = intent.getExtras().getString("placeName");
        int placeImage = intent.getExtras().getInt("placeImage");
        String placeDescription = intent.getExtras().getString("placeDescription");
        String placeInformation = intent.getExtras().getString("placeInformation");

        // Set the toolbar title to be the name of the selected item and set the Collapsing effect.
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(placeName);

        // Set the top ImageView to be the image imported from the selected item.
        ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(placeImage).apply(RequestOptions.centerCropTransform()).into(imageView);

        // Set the description TextView to be the description imported from the selected item.
        TextView descriptionTextView = (TextView) findViewById(R.id.textview_description);
        descriptionTextView.setText(placeDescription);

        // Set the information TextView to be the information imported from the selected item.
        TextView informationTextView = (TextView) findViewById(R.id.textview_information);
        informationTextView.setText(placeInformation);
    }
}

