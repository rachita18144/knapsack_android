package com.example.saumya.knapsack.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.adapters.TabAdapter;
import com.example.saumya.knapsack.fragments.FriendsFragment;
import com.example.saumya.knapsack.fragments.GalleryFragment;
import com.example.saumya.knapsack.fragments.StatsFragment;
import com.google.android.material.tabs.TabLayout;

public class FriendProfileActivity extends AppCompatActivity implements GalleryFragment.OnFragmentInteractionListener, FriendsFragment.OnFragmentInteractionListener, StatsFragment.OnFragmentInteractionListener {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_profile);
        viewPager = findViewById(R.id.friend_viewPager);
        tabLayout = findViewById(R.id.friend_tabLayout);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new GalleryFragment(), "PHOTOS");
        adapter.addFragment(new FriendsFragment(), "FRIENDS");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        pic=findViewById(R.id.profile_img_post);

        Intent intent = getIntent();
        String name = intent.getStringExtra("friend_name");
        int imageurl= intent.getIntExtra("imageurl",0);
        pic.setImageResource(imageurl);
        TextView friendName = (TextView)findViewById(R.id.friend_name);
        friendName.setText(name);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
