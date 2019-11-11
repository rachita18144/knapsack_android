package com.example.saumya.knapsack.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.adapters.CommentsAdapter;

import java.util.ArrayList;

public class PlaceActivity extends AppCompatActivity {

    ImageView topImageView;
    TextView placeNameTextView;
    ArrayList<String> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        initialize();
        Intent intent = getIntent();
        setBackgroundImage(intent.getStringExtra("image_url"));
        setPlaceName(intent.getStringExtra("name"));
    }

    void initialize() {
        topImageView = findViewById(R.id.place_activity_image_view_background_top);
        placeNameTextView = findViewById(R.id.place_activity_text_view_place_name);
        placeNameTextView.setTypeface(null, Typeface.BOLD);
        comments = new ArrayList<String>();
        initRecyclerView();
    }

    public void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.place_activity_recycler_view);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        comments.add("This place is awesome. Weather is nice.");
        comments.add("A great place for a perfect weekend. Loved it");
        comments.add("Its too hot and humid. Overall nice place");
        CommentsAdapter mAdapter = new CommentsAdapter(this, comments);
        recyclerView.setAdapter(mAdapter);
    }


    void setPlaceName(String name) {
        placeNameTextView.setText(name);
    }

    void setBackgroundImage(String url) {

        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        Glide.with(this)
                .load(url)
                .apply(requestOptions)
                .into(topImageView);

    }
}
