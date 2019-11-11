package com.example.saumya.knapsack.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Register {

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    @SerializedName("places")
    private ArrayList<String> places;

    @SerializedName("how_travel")
    private ArrayList<String> how_travel;

    public Register(String email, String password, ArrayList<String> places, ArrayList<String> how_travel){
        this.email= email;
        this.password = password;
        this.places = places;
        this.how_travel = how_travel;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public ArrayList<String> getPlaces ()
    {
        return places;
    }

    public void setPlaces (ArrayList<String> places)
    {
        this.places = places;
    }

    public ArrayList<String> getHow_travel ()
    {
        return how_travel;
    }

    public void setHow_travel (ArrayList<String> how_travel)
    {
        this.how_travel = how_travel;
    }

}
