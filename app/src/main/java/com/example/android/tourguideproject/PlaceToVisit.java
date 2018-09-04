package com.example.android.tourguideproject;

/**
 * {@link PlaceToVisit} represents the name of the recommended location in the Tokyo Guide.
 * It contains the name of the place, an image representing that place, a description about the
 * place and the information (address, opening hours, etc) regarding that place.
 */

public class PlaceToVisit {

    //Name of the place to visit.
    private String mPlaceName;

    //Image resource ID for the place to visit.
    private int mImageResourceId;

    //Description of the place to visit.
    private String mPlaceDescription;

    //Information regarding the place to visit.
    private String mPlaceInformation;

    /**
     * Create a new PlaceToVisit object.
     *
     * @param placeName       is the name of the recommended place to visit.
     * @param imageResourceId is the resource ID for the image file associated with this location.
     * @param placeDescription is the description of the recommended place to visit.
     * @param placeInformation is the information regarding that location (address, etc).
     */
    public PlaceToVisit(String placeName, int imageResourceId, String placeDescription, String placeInformation) {
        mPlaceName = placeName;
        mImageResourceId = imageResourceId;
        mPlaceDescription = placeDescription;
        mPlaceInformation = placeInformation;
    }

        //Get the name of the place.
        public String getPlaceName () {
            return mPlaceName;
        }

        //Return the image resource ID of this location.
        public int getImageResourceId () {
            return mImageResourceId;
        }

        //Get the description of the place to visit.
        public String getPlaceDescription () {
            return mPlaceDescription;
        }

        //Get the information regarding the place to visit.
        public String getPlaceInformation () {
            return mPlaceInformation;
        }
    }

