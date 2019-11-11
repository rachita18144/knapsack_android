package com.example.saumya.knapsack.activities;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.saumya.knapsack.R;
import com.example.saumya.knapsack.network.RegisterInterface;
import com.example.saumya.knapsack.network.RetrofitConnect;
import com.example.saumya.knapsack.pojo.Register;

import java.util.ArrayList;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreferencesStartupActivity extends AppCompatActivity {

    private Button skip,finish;
    private CardView solo,friends,newpeople,family,mount,tropics,valley,metro,heritage,escapes;
    HashMap<String,Integer> s=new HashMap<>();
    private Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        c=this;
        skip=findViewById(R.id.skipButton);
        finish=findViewById(R.id.finish);
        mount=findViewById(R.id.mount);
        tropics=findViewById(R.id.tropics);
        heritage=findViewById(R.id.heritage);
        metro=findViewById(R.id.metro);
        valley=findViewById(R.id.valley);
        escapes=findViewById(R.id.escapes);

        solo=findViewById(R.id.solo);
        friends=findViewById(R.id.friends);
        newpeople=findViewById(R.id.new_people);
        family=findViewById(R.id.family);

        //get intent values
        Intent intent = getIntent();
        final String email = intent.getStringExtra("email");
        final String password = intent.getStringExtra("password");

        s.put("Mountains",0);
        s.put("Tropics",0);
        s.put("Valley",0);
        s.put("Heritage",0);
        s.put("Metro",0);
        s.put("Escapes",0);
        s.put("Solo",0);
        s.put("Family",0);
        s.put("Friends",0);
        s.put("NewPeople",0);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start home activity after getting response from server
                sendRegistrationDataToApi(email, password, s);
                Intent intent= new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
                Log.d("saumya","---"+s);
            }
        });

        mount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=s.get("Mountains");
                int r=setVal("Mountains",v);
                if(r==1)
                {
                    mount.setForeground(ContextCompat.getDrawable(c,R.drawable.tick));
                    mount.setForegroundGravity(48);
                }
                else
                {
                    mount.setForeground(null);
                }
            }
        });

        tropics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=s.get("Tropics");
                int r=setVal("Tropics",v);
                if(r==1)
                {
                    tropics.setForeground(ContextCompat.getDrawable(c,R.drawable.tick));
                    tropics.setForegroundGravity(48);
                }
                else
                {
                    tropics.setForeground(null);
                }
            }
        });

        valley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=s.get("Valley");
                int r=setVal("Valley",v);
                if(r==1)
                {
                    valley.setForeground(ContextCompat.getDrawable(c,R.drawable.tick));
                    valley.setForegroundGravity(48);
                }
                else
                {
                    valley.setForeground(null);
                }
            }
        });

        metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=s.get("Metro");
                int r=setVal("Metro",v);
                if(r==1)
                {
                    metro.setForeground(ContextCompat.getDrawable(c,R.drawable.tick));
                    metro.setForegroundGravity(48);
                }
                else
                {
                    metro.setForeground(null);
                }
            }
        });

        heritage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=s.get("Heritage");
                int r=setVal("Heritage",v);
                if(r==1)
                {
                    heritage.setForeground(ContextCompat.getDrawable(c,R.drawable.tick));
                    heritage.setForegroundGravity(48);
                }
                else
                {
                    heritage.setForeground(null);
                }
            }
        });

        escapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=s.get("Escapes");
                int r=setVal("Escapes",v);
                if(r==1)
                {
                    escapes.setForeground(ContextCompat.getDrawable(c,R.drawable.tick));
                    escapes.setForegroundGravity(48);
                }
                else
                {
                    escapes.setForeground(null);
                }
            }
        });

        solo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=s.get("Solo");
                int r=setVal("Solo",v);
                if(r==1)
                {
                    solo.setForeground(ContextCompat.getDrawable(c,R.drawable.tick));
                    solo.setForegroundGravity(48);
                }
                else
                {
                    solo.setForeground(null);
                }
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=s.get("Family");
                int r=setVal("Family",v);
                if(r==1)
                {
                    family.setForeground(ContextCompat.getDrawable(c,R.drawable.tick));
                    family.setForegroundGravity(48);
                }
                else
                {
                    family.setForeground(null);
                }
            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=s.get("Friends");
                int r=setVal("Friends",v);
                if(r==1)
                {
                    friends.setForeground(ContextCompat.getDrawable(c,R.drawable.tick));
                    friends.setForegroundGravity(48);
                }
                else
                {
                    friends.setForeground(null);
                }
            }
        });

        newpeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=s.get("NewPeople");
                int r=setVal("NewPeople",v);
                if(r==1)
                {
                    newpeople.setForeground(ContextCompat.getDrawable(c,R.drawable.tick));
                    newpeople.setForegroundGravity(48);
                }
                else
                {
                    newpeople.setForeground(null);
                }
            }
        });

    }

    public int setVal(String key,int val)
    {
        if(val==0)
        {
            s.put(key,1);
            Log.d("saumya",key+" old "+val+" new "+s.get(key));
            return 1;
        }
        else
        {
            s.put(key,0);
            Log.d("saumya",key+" old "+val+" new "+s.get(key));
            return 0;
        }
    }

    public void sendRegistrationDataToApi(String email, String password, HashMap<String,Integer> smap)
    {
        ArrayList<String> places = new ArrayList<String>();
        ArrayList<String> howTravel = new ArrayList<String>();

        System.out.println("hereeeeee");
        System.out.println(smap);
        for (HashMap.Entry<String, Integer> entry : smap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value == 1){
                if(key.equals("Mountains")){
                    places.add("Mountains");
                }
                if(key.equals("Tropics")){
                    places.add("Tropics");
                }
                if(key.equals("Escapes")){
                    places.add("Escapes");
                }
                if(key.equals("Heritage")){
                    places.add("Heritage");
                }
                if(key.equals("Metro")){
                    places.add("Metro");
                }
                if(key.equals("Family")){
                    places.add("Family");
                }
                if(key.equals("Solo")){
                    places.add("Solo");
                }
                if(key.equals("NewPeople")){
                    places.add("NewPeople");
                }
                if(key.equals("Friends")){
                    places.add("Friends");
                }
                if(key.equals("Valley")){
                    places.add("Valley");
                }
            }
        }
        Register register = new Register(email, password, places, howTravel);
        RegisterInterface service = RetrofitConnect.getRetrofitInstance().create(RegisterInterface.class);

        //Call<Register> call = service.createUser(register);
    }
}
