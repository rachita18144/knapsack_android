package com.example.saumya.knapsack.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.adapters.TabAdapter;
import com.example.saumya.knapsack.fragments.FriendsFragment;
import com.example.saumya.knapsack.fragments.GalleryFragment;
import com.example.saumya.knapsack.fragments.HomeFragment;
import com.example.saumya.knapsack.fragments.MyTripsFragment;
import com.example.saumya.knapsack.fragments.ProfileFragment;
import com.example.saumya.knapsack.fragments.SOSFragment;
import com.example.saumya.knapsack.fragments.StatsFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity implements GalleryFragment.OnFragmentInteractionListener,FriendsFragment.OnFragmentInteractionListener,StatsFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener,MyTripsFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener,SOSFragment.OnFragmentInteractionListener
{
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView preferenes;
//    private BottomNavigationView bv;
    public Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        c=this;
//        bv= (BottomNavigationView)findViewById(R.id.navigationView);
        adapter = new TabAdapter(getSupportFragmentManager());
        Log.d("saumya","hereee");
        adapter.addFragment(new GalleryFragment(), "PHOTOS");
        adapter.addFragment(new FriendsFragment(), "FRIENDS");
        adapter.addFragment(new StatsFragment(), "MY STATS");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        preferenes = findViewById(R.id.settings);
        preferenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Intent i = new Intent(ProfileActivity.this, PreferencesActivity.class);
                startActivity(i);
            }
        });

//        bv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item)
//            {
//                switch (item.getItemId()) {
//                    case R.id.navigation_home:
//                        replaceAndSetFragment(new HomeFragment());
//                        return true;
//                    case R.id.navigation_mytrips:
//                        replaceAndSetFragment(new MyTripsFragment());
//                        return true;
//                    case R.id.navigation_profile:
////                        Intent profile = new Intent(getApplicationContext(), ProfileActivity.class);
////                        c.startActivity(profile);
//                        //  replaceAndSetFragment(new ProfileFragment());
//                        //   fragmentTransaction.replace(R.id.fragment_container, new ProfileFragment()).commit();
//                        return true;
//                    case R.id.navigation_sos:
//                        replaceAndSetFragment(new SOSFragment());
//                        return true;
//                }
//                return false;
//            }
//        });
    }
    private void replaceAndSetFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_containerr, fragment, fragment.getClass().getSimpleName())
                .commit();
        setSelectedFragmentId(fragment.getClass().getSimpleName());


    }

    public void setSelectedFragmentId(String selectedFragmentId) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
