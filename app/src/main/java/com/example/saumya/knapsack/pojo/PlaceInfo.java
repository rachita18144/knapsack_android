package com.example.saumya.knapsack.pojo;

import android.util.Log;
import android.widget.ImageView;

public class PlaceInfo
{
    private String placeName,fromDate,toDate,description;


    public PlaceInfo(String placeName,String fd, String td, String desc)
    {
        this.placeName=placeName;
        this.fromDate=fd;
        this.toDate=td;
        this.description=desc;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void print()
    {
        Log.d("saumya",placeName+" "+fromDate+" TO "+toDate+" "+description);
    }
}
