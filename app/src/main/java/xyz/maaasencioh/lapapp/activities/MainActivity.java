package xyz.maaasencioh.lapapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.maaasencioh.lapapp.R;
import xyz.maaasencioh.lapapp.adapters.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.container)
    ViewPager container;

    private final static String ABOUT_URL = "http://maasencioh.xyz/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager(), getApplicationContext());

        // Set up the ViewPager with the sections adapter.
        container.setAdapter(adapter);
        tabs.setupWithViewPager(container);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            about();
        }

        return super.onOptionsItemSelected(item);
    }

    private void about() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(ABOUT_URL));
        startActivity(intent);
    }
}
