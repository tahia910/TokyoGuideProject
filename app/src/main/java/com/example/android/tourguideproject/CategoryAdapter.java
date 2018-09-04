package com.example.android.tourguideproject;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link PlaceToVisit} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    // Context of the app
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CategoryVisitFragment();
        } else if (position == 1) {
            return new CategoryShoppingFragment();
        } else if (position == 2) {
            return new CategoryFunFragment();
        } else {
            return new CategoryEatFragment();
        }
    }

    // Return the total number of pages.
    @Override
    public int getCount() {
        return 4;
    }

    // Get the title of the fragment for the page title.
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_visit);
        } else if (position == 1) {
            return mContext.getString(R.string.category_shopping);
        } else if (position == 2) {
            return mContext.getString(R.string.category_fun);
        } else {
            return mContext.getString(R.string.category_eat);
        }
    }
}