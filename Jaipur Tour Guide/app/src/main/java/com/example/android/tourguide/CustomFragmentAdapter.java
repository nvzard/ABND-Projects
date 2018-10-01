package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CustomFragmentAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HotelFragment();
        } else if (position == 1) {
            return new FoodFragment();
        } else if (position == 2) {
            return new SitesFragment();
        } else {
            return new ClubsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.Hotels);
        } else if (position == 1) {
            return mContext.getString(R.string.Food);
        } else if (position == 2) {
            return mContext.getString(R.string.Sites);
        } else {
            return mContext.getString(R.string.Clubs);
        }
    }
}
