package com.example.saumya.knapsack.pojo;

import android.widget.ImageView;

public class TripsRec
{
private String imageurl;
private String placeName;

public TripsRec(String name, String url)
{
    placeName=name;
    imageurl=url;
}

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

}
