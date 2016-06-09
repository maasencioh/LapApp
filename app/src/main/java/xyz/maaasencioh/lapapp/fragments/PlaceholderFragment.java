package xyz.maaasencioh.lapapp.fragments;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.maaasencioh.lapapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private Boolean running;

    @BindView(R.id.chronometer)
    Chronometer chronometer;

    public PlaceholderFragment() {
        running = false;
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.chronometer)
    public void onClick() {
        if (running) {
            chronometer.stop();
        }
        else {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
        }
        running = !running;
    }
}
