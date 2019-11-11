package com.example.saumya.knapsack.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.pojo.ContactList;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.MyViewHolder>
{
    public interface OnItemClickListener
    {
        void onItemClick(ContactList cl);
    }
    private List<ContactList> list;
    private final OnItemClickListener listener;


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView name,contact;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            contact = (TextView) view.findViewById(R.id.number);
        }

        public void bind(final ContactList c,final OnItemClickListener listener)
        {
            itemView.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    listener.onItemClick(c);
                }
            });
        }
    }

    public ContactListAdapter(List<ContactList> list, OnItemClickListener listener)
    {
        this.list = list;
        this.listener=listener;
    }
    @NonNull
    @Override
    public ContactListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_layout, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ContactListAdapter.MyViewHolder holder, int position) {
        ContactList contact = list.get(position);
        holder.name.setText(contact.getName());
        holder.contact.setText(contact.getNumber());
        holder.bind(contact,listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
