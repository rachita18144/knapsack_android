package com.example.saumya.knapsack.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.saumya.knapsack.R;

public class SplashActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent login = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(login);
                SplashActivity.this.finish();
            }
        },2000);
    }
}
