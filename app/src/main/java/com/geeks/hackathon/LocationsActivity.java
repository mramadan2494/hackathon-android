package com.geeks.hackathon;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;


import butterknife.BindView;
import butterknife.ButterKnife;
import widgets.ViewPagerAdapter;

public class LocationsActivity extends AppCompatActivity {


    @BindView(R.id.customer_main_tabs)
    TabLayout tabLayout;
    @BindView(R.id.customer_main_pager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private boolean isReceiverRegistered;
    private static String TAG= "Locations";

    GroupFragment groupFragment;
    PlacesFragment placesFragment;

    public static String INTENT_PUSH_NOTIFICATION = "intentPushNotification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        ButterKnife.bind(this);


        // to log the first time
        toolbar.setTitle("My group");


        setupViewPager();
    }


    @Override
    public void onStart() {
        Log.d(TAG,"OnStart");
        super.onStart();



    }

    @Override
    protected void onResume() {
        Log.d(TAG,"onResume");
        super.onResume();

    }

    //Unregistering receiver on activity paused
    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause");
    }

    @Override
    public void onStop() {
        Log.d(TAG,"onStop");
        super.onStop();


    }

    /**
     * set view pager and add fragments
     */
    private void setupViewPager() {


        groupFragment =new GroupFragment();
        placesFragment=new PlacesFragment();


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFrag(groupFragment, "");

        viewPagerAdapter.addFrag(placesFragment, "");

        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.v("onPageSelected", "" + position);
                if (position == 0) {
                    toolbar.setTitle("My group");

                }
                else if (position == 1) {
                    toolbar.setTitle("Places");

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.group);
        tabLayout.getTabAt(1).setIcon(R.drawable.place);
        //tabLayout.getTabAt(2).setIcon(tech.gplanet.shopx.R.drawable.ic_menu);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.whiteColor));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(tech.gplanet.shopx.R.menu.main_menu, menu);
        Log.d(TAG,"onCreateOptionsMenu");
        return true;
    }



}
