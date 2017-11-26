package com.justforfun.automatabuilder.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hectormoreno on 11/25/17.
 */

public class NewBrainTabAdapter extends FragmentPagerAdapter {
    public NewBrainTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
