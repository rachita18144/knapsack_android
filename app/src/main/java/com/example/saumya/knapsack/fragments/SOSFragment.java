package com.example.saumya.knapsack.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.activities.HomeActivity;
import com.example.saumya.knapsack.adapters.ContactListAdapter;
import com.example.saumya.knapsack.pojo.ContactList;

import java.util.ArrayList;
import java.util.List;


public class SOSFragment extends Fragment {

    private HomeFragment.OnFragmentInteractionListener mListener;
    private List<ContactList> c_list = new ArrayList<>();
    private List<ContactList> a_list = new ArrayList<>();
    private RecyclerView recyclerView1,recyclerView2;
    private ContactListAdapter mAdapter1,mAdapter2;
    private TextView sos;
    public Context c;
    View view;
    public SOSFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view= inflater.inflate(R.layout.fragment_so, container, false);
        sos=(TextView)view.findViewById(R.id.sos_);
        recyclerView1 = (RecyclerView)view.findViewById(R.id.contacts);
        recyclerView2 = (RecyclerView)view.findViewById(R.id.authorities);
        mAdapter1 = new ContactListAdapter(c_list, new ContactListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ContactList cl) {
//                Toast.makeText(getActivity().getApplicationContext(),"contact no is : "+cl.getNumber(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + cl.getNumber()));
                view.getContext().startActivity(intent);
            }
        });
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(view.getContext());
        recyclerView1.setLayoutManager(mLayoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(mAdapter1);

        mAdapter2 = new ContactListAdapter(a_list, new ContactListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ContactList cl) {
//                Toast.makeText(getActivity().getApplicationContext(),"contact no is : "+cl.getNumber(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + cl.getNumber()));
                view.getContext().startActivity(intent);
            }
        });
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(view.getContext());
        recyclerView2.setLayoutManager(mLayoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(mAdapter2);

        prepareContactData();
        prepareAuthoritiesData();
        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(),"SOS ACTIVATED ",Toast.LENGTH_LONG).show();
                String n=c_list.get(0).getNumber();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + n));
                view.getContext().startActivity(intent);
            }
        });
        return view;
    }

    private void prepareContactData() {
        ContactList c0= new ContactList("Aarohi","8901389969");
        c_list.add(c0);
        ContactList c1= new ContactList("Sonali","8937468282");
        c_list.add(c1);
        ContactList c2= new ContactList("Rachita","9022838822");
        c_list.add(c2);
        mAdapter1.notifyDataSetChanged();
    }

    private void prepareAuthoritiesData() {
        ContactList c1= new ContactList("Police","102");
        a_list.add(c1);
        ContactList c2= new ContactList("Ambulance","103");
        a_list.add(c2);
        mAdapter2.notifyDataSetChanged();
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (HomeFragment.OnFragmentInteractionListener) context;
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
