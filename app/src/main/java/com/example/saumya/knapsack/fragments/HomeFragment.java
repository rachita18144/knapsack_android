package com.example.saumya.knapsack.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saumya.knapsack.activities.FriendProfileActivity;
import com.google.android.material.card.MaterialCardView;

import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.adapters.TripsRecPagerAdapter;
import com.example.saumya.knapsack.pojo.TripsRec;

import java.util.ArrayList;

public class HomeFragment extends Fragment
{
    private ImageView user1,user2,user3,visitedplace;
    private OnFragmentInteractionListener mListener;
    public Context c;
    public ViewPager viewPager;
    public MaterialCardView v1,v2,v3,v4,v5,v6;
    public ImageView i1,i2,i3,i4,i5,i6;
    TextView t1,t2,t3,t4,t5,t6;
    TripsRec obj1=new TripsRec("Paris","https://images.unsplash.com/photo-1499856871958-5b9627545d1a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1007&q=80");
    TripsRec obj2=new TripsRec("London","https://images.unsplash.com/photo-1505761671935-60b3a7427bad?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80");
    TripsRec obj3=new TripsRec("Portugal","https://i.redd.it/qn7f9oqu7o501.jpg");
    TripsRec obj4=new TripsRec("Andaman","https://i.redd.it/0h2gm1ix6p501.jpg");
    TripsRec obj5=new TripsRec("Germany","https://images.unsplash.com/photo-1501952476817-d7ae22e8ee4e?ixlib=rb-1.2.1&auto=format&fit=crop&w=1049&q=80");
    private ArrayList<TripsRec> mylist=new ArrayList<TripsRec>();

    public HomeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = (ViewPager)view.findViewById(R.id.viewPagerhome);
        c=view.getContext();
        v1= view.findViewById(R.id.view1);
        v2= view.findViewById(R.id.view2);
        v3= view.findViewById(R.id.view3);
        v4= view.findViewById(R.id.view4);
        v5= view.findViewById(R.id.view5);
        v6= view.findViewById(R.id.view6);
        t1= view.findViewById(R.id.t1);
        t2= view.findViewById(R.id.t2);
        t3= view.findViewById(R.id.t3);
        t4= view.findViewById(R.id.t4);
        t5= view.findViewById(R.id.t5);
        t6= view.findViewById(R.id.t6);
        i1= view.findViewById(R.id.i1);
        i2= view.findViewById(R.id.i2);
        i3= view.findViewById(R.id.i3);
        i4= view.findViewById(R.id.i4);
        i5= view.findViewById(R.id.i5);
        i6= view.findViewById(R.id.i6);
        Log.d("saumya",viewPager+" ");
        mylist.add(obj1);
        mylist.add(obj2);
        mylist.add(obj3);
        mylist.add(obj4);
        mylist.add(obj5);
        viewPager.setAdapter(new TripsRecPagerAdapter(getContext(),mylist));
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Intent i = new Intent(view.getContext(), FriendProfileActivity.class);
                i.putExtra("friend_name",t1.getText().toString());
                int resourceId = c.getResources().getIdentifier("saumya", "drawable", c.getPackageName());
                i.putExtra("imageurl",resourceId);
                view.getContext().startActivity(i);
            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Intent i = new Intent(view.getContext(), FriendProfileActivity.class);
                i.putExtra("friend_name",t2.getText().toString());
                int resourceId = c.getResources().getIdentifier("profile_img", "drawable", c.getPackageName());
                i.putExtra("imageurl",resourceId);
                view.getContext().startActivity(i);
            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Intent i = new Intent(view.getContext(), FriendProfileActivity.class);
                i.putExtra("friend_name",t3.getText().toString());
                int resourceId = c.getResources().getIdentifier("sonali", "drawable", c.getPackageName());
                i.putExtra("imageurl",resourceId);
                view.getContext().startActivity(i);
            }
        });
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Intent i = new Intent(view.getContext(), FriendProfileActivity.class);
                i.putExtra("friend_name",t4.getText().toString());
                int resourceId = c.getResources().getIdentifier("sud", "drawable", c.getPackageName());
                i.putExtra("imageurl",resourceId);
                view.getContext().startActivity(i);
            }
        });
        v5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Intent i = new Intent(view.getContext(), FriendProfileActivity.class);
                i.putExtra("friend_name",t5.getText().toString());
                int resourceId = c.getResources().getIdentifier("tae", "drawable", c.getPackageName());
                i.putExtra("imageurl",resourceId);
                view.getContext().startActivity(i);
            }
        });
        v6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Intent i = new Intent(view.getContext(), FriendProfileActivity.class);
                i.putExtra("friend_name",t6.getText().toString());
                int resourceId = c.getResources().getIdentifier("jin", "drawable", c.getPackageName());
                i.putExtra("imageurl",resourceId);
                view.getContext().startActivity(i);
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
