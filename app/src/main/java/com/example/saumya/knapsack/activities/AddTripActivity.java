package com.example.saumya.knapsack.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.pojo.PlaceInfo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddTripActivity extends AppCompatActivity {

    EditText pName,fromdate,frommonth,fromyear,todate,tomonth,toyear,placeDesc;
    Button gallery,addTrip;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        pName= findViewById(R.id.pName);
        fromdate= findViewById(R.id.fromdate);
        frommonth= findViewById(R.id.frommonth);
        fromyear= findViewById(R.id.fromyear);
        todate= findViewById(R.id.todate);
        tomonth= findViewById(R.id.tomonth);
        toyear= findViewById(R.id.toyear);
        placeDesc= findViewById(R.id.placeDesc);
        gallery= (Button)findViewById(R.id.galleryImport);
        addTrip= (Button)findViewById(R.id.addtripbutton);
        imageView=findViewById(R.id.imageView);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), 1);
            }
        });

        addTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= pName.getText().toString();
                String fd= fromdate.getText().toString()+" "+frommonth.getText()+" "+fromyear.getText();
                String td= todate.getText().toString()+" "+tomonth.getText()+" "+toyear.getText();
                String des= placeDesc.getText().toString();
                PlaceInfo p= new PlaceInfo(name,fd,td,des);
                p.print();
                pName.getText().clear();
                fromdate.getText().clear();
                frommonth.getText().clear();
                fromyear.getText().clear();
                todate.getText().clear();
                tomonth.getText().clear();
                toyear.getText().clear();
                placeDesc.getText().clear();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
