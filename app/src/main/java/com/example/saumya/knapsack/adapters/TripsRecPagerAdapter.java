package com.example.saumya.knapsack.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.activities.PlaceActivity;
import com.example.saumya.knapsack.pojo.TripsRec;

import java.util.ArrayList;

public class TripsRecPagerAdapter extends PagerAdapter
{
    private Context c;
    LayoutInflater layoutInflater;
    ArrayList<TripsRec>mylist;

    public TripsRecPagerAdapter(Context context, ArrayList mylist)
    {
        c=context;
        this.mylist=mylist;
        layoutInflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.tripitems, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.Visitedplace);
        TextView placeName= (TextView) itemView.findViewById(R.id.placeName);
        placeName.setText(mylist.get(position).getPlaceName());
        Glide.with(c)
                .load(mylist.get(position).getImageurl())
                .into(imageView);

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c, PlaceActivity.class);
                i.putExtra("image_url", mylist.get(position).getImageurl());
                i.putExtra("name", mylist.get(position).getPlaceName());
                c.startActivity(i);
//                Toast.makeText(c, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
