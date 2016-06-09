package xyz.maaasencioh.lapapp.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import xyz.maaasencioh.lapapp.R;
import xyz.maaasencioh.lapapp.fragments.PlaceholderFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] titles;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        this.titles = new String[]{
                context.getString(R.string.general_section_free),
                context.getString(R.string.general_section_time),
                context.getString(R.string.general_section_laps)
        };
    }

    @Override
    public Fragment getItem(int position) {
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if ((position < titles.length) && (position >= 0))
            return titles[position];
        return null;
    }
}
