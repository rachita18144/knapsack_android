package com.example.saumya.knapsack.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.adapters.FriendsRecyclerViewAdapter;

import java.util.ArrayList;

public class FriendsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ArrayList<String> profileImageUrls = new ArrayList<>();
    private ArrayList<String> profileNames = new ArrayList<>();

    View v;
    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.fragment_friends, container, false);
        inflateDataRecyclerView();
        return v;
    }

    public void inflateDataRecyclerView(){
        profileNames.add("Rachita");
        profileNames.add("Saumya");
        profileNames.add("Sonali");
        profileNames.add("Honululu");
        profileNames.add("Rohan");
        profileNames.add("Jason");
        profileNames.add("Christan");
        profileNames.add("Sudatta");
        profileNames.add("Latte");
        profileNames.add("Cappuccino");
        profileNames.add("Mickey");
        initRecyclerView();
    }

    public void initRecyclerView() {
        RecyclerView recyclerView = v.findViewById(R.id.friendsrecyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        FriendsRecyclerViewAdapter mAdapter = new FriendsRecyclerViewAdapter(getContext(), profileNames);
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
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
