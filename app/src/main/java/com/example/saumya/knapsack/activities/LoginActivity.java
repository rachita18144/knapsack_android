package com.example.saumya.knapsack.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saumya.knapsack.R;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity
{
EditText email,password;
TextView register;
Button login;
//private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_login);
//        mAuth= FirebaseAuth.getInstance();
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        register=(TextView)findViewById(R.id.register);
        login=(Button)findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_ = email.getText().toString();
                String password_ = password.getText().toString();
                boolean check = checkValidation(email_, password_);
                Log.d("knap","Checks passed");
                if(!check){
                    Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    Log.d("knap","calling login firebase");
                    loginUser(email_, password_);
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent= new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(registerIntent);
             //   Toast.makeText(getApplicationContext(), "Register Activity called", Toast.LENGTH_LONG).show();
            }
        });
    }

    boolean checkValidation(String email_, String password_){
        boolean check = true;
        if(email_.isEmpty()){
            email.setError("Username is required");
            email.requestFocus();
            check = false;
        }

        if(password_.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            check = false;
        }

        if(email_.length() <3){
            email.setError("Username should be atleast 3 characters long");
            email.requestFocus();
            check = false;
        }

        if(password_.length() <5){
            password.setError("password should be atleast 5 characters long");
            password.requestFocus();
            check = false;
        }
        if(email_ == "" || password_ == "" || email_.length() <3 || password_.length() <5){
            check = false;
        }
        return check;
    }

    void loginUser(String username, String password){

        Log.d("knap",username+" "+password);
        final Intent loginintent= new Intent(LoginActivity.this, HomeActivity.class);
        Toast.makeText(LoginActivity.this, "Authentication success.", Toast.LENGTH_SHORT).show();
        startActivity(loginintent);
//        mAuth.signInWithEmailAndPassword(username, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            final Intent loginintent= new Intent(LoginActivity.this, HomeActivity.class);
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            Toast.makeText(LoginActivity.this, "Authentication success.", Toast.LENGTH_SHORT).show();
//                            Log.d("knap","UID IS "+user.getUid()+" "+user.getDisplayName());
//                            loginintent.putExtra("uid",user.getUid());
//                            startActivity(loginintent);
//                        } else {
//                            Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
    }
}
