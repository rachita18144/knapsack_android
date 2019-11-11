package com.example.saumya.knapsack.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.activities.AddTripActivity;
import com.example.saumya.knapsack.activities.ProfileActivity;
import com.example.saumya.knapsack.adapters.TripsRecPagerAdapter;
import com.example.saumya.knapsack.pojo.TripsRec;

import java.util.ArrayList;

public class MyTripsFragment extends Fragment
{
    private OnFragmentInteractionListener mListener;
    ViewPager viewPager_up, viewPager_p;
    ImageView addTrip;
    TripsRec obj1=new TripsRec("Seoul","https://www.anepiceducation.com/wp-content/uploads/2020/08/things-to-do-in-Seoul.jpg");
    TripsRec obj2=new TripsRec("Daegu","https://images.unsplash.com/photo-1531931477284-7e16215c9540?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1868&q=80");
    TripsRec obj3=new TripsRec("Japan","https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80");

    TripsRec obj6=new TripsRec("Busan","https://wallpaperaccess.com/full/17673.jpg");
    TripsRec obj4=new TripsRec("Arizona","https://images.unsplash.com/photo-1529599087-bcf1dc4a7ae4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1004&q=80");
    TripsRec obj8=new TripsRec("Norway","https://www.projectinspo.com/wp-content/uploads/2019/01/iceland-northern-lights-project-inspo.jpg?w=640");
    TripsRec obj7=new TripsRec("Abu Dhabi","https://cdn.fstoppers.com/styles/large-16-9/s3/lead/2015/06/travel-photography-career-sahara-morocco-camels-hillary-fox.jpg");
    private ArrayList<TripsRec> upcoming=new ArrayList<TripsRec>();
    private ArrayList<TripsRec> past=new ArrayList<TripsRec>();

    public MyTripsFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_my_trips, container, false);
        addTrip= view.findViewById(R.id.addTrip);
        upcoming.add(obj1);
        upcoming.add(obj2);
        upcoming.add(obj3);
        past.add(obj4);
        past.add(obj6);
        past.add(obj7);
        past.add(obj8);
        viewPager_up = (ViewPager)view.findViewById(R.id.viewPagerupcoming);
        viewPager_p= (ViewPager)view.findViewById(R.id.viewPagerpast);
        viewPager_up.setAdapter(new TripsRecPagerAdapter(getContext(),upcoming));
        viewPager_p.setAdapter(new TripsRecPagerAdapter(getContext(),past));

        addTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(getActivity().getApplicationContext(), AddTripActivity.class);
               startActivity(i);
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
