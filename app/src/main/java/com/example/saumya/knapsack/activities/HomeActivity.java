package com.example.saumya.knapsack.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.fragments.HomeFragment;
import com.example.saumya.knapsack.fragments.MyTripsFragment;
import com.example.saumya.knapsack.fragments.ProfileFragment;
import com.example.saumya.knapsack.fragments.SOSFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,MyTripsFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener,SOSFragment.OnFragmentInteractionListener
{
    private String selectedFragmentId;
    private BottomNavigationView bv;
    public Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        c=this;

        bv= (BottomNavigationView)findViewById(R.id.navigationView);
        Fragment fragment = null;
        fragment = new HomeFragment();
        replaceAndSetFragment(fragment);

        bv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        replaceAndSetFragment(new HomeFragment());
                        return true;
                    case R.id.navigation_mytrips:
                        replaceAndSetFragment(new MyTripsFragment());
                        return true;
                    case R.id.navigation_profile:
                        Intent profile = new Intent(getApplicationContext(), ProfileActivity.class);
                        c.startActivity(profile);
                      //  replaceAndSetFragment(new ProfileFragment());
                     //   fragmentTransaction.replace(R.id.fragment_container, new ProfileFragment()).commit();
                        return true;
                    case R.id.navigation_sos:
                        replaceAndSetFragment(new SOSFragment());
                        return true;
                        }
                return false;
             }
        });
    }



    private void replaceAndSetFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName())
                .commit();
        setSelectedFragmentId(fragment.getClass().getSimpleName());


    }

    public void setSelectedFragmentId(String selectedFragmentId) {
        this.selectedFragmentId = selectedFragmentId;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
