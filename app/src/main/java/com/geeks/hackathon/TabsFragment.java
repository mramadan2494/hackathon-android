package com.geeks.hackathon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import widgets.ViewPagerAdapter;


public class TabsFragment extends Fragment {

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

    public TabsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        View view = inflater.inflate(R.layout.fragment_tabs, container, false);
        ButterKnife.bind(this, view);
        // to log the first time
        toolbar.setTitle("My group");


        setupViewPager();
        return view;
    }


    /**
     * set view pager and add fragments
     */
    private void setupViewPager() {


        groupFragment =new GroupFragment();
        placesFragment=new PlacesFragment();


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

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

}
