package com.overseastechnologies.GradeApp.ui.Statistics;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.overseastechnologies.GradeApp.fragments.statistics.FragmentAttendance;
import com.overseastechnologies.GradeApp.fragments.statistics.FragmentOtherActivities;
import com.overseastechnologies.GradeApp.fragments.statistics.FragmentResult;

import GradeApp.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[] {R.string.tab_text_attendance, R.string.tab_text_result, R.string.tab_text_other_activities};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position){
            case 0 :
                fragment = new FragmentAttendance();
                break;
            case 1 :
                fragment = new FragmentResult();
                break;

            case 2 :
                fragment = new FragmentOtherActivities();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}