package com.example.saumya.knapsack.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saumya.knapsack.R;

public class RegisterActivity extends AppCompatActivity {
   private Button register;
    private TextView username, password, confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView logintext = findViewById(R.id.login_id);
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);

        register=(Button)findViewById(R.id.signup);
        logintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = checkValidation(username.getText().toString(), password.getText().toString(), confirmPassword.getText().toString());
                if(!check){
                    Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Register successful", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent();
                Intent i = new Intent(RegisterActivity.this, PreferencesStartupActivity.class);
                i.putExtra("email", username.getText().toString());
                i.putExtra("password", password.getText().toString());
                startActivity(i);
            }
        });

    }

    private boolean checkValidation(String u_name, String pass, String c_pass) {
        boolean check = true;
        if(u_name.isEmpty()){
            username.setError("Username is required");
            username.requestFocus();
            check = false;
        }
        if(pass.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            check = false;
        }
        if(c_pass.isEmpty()){
            confirmPassword.setError("Confirm password is required");
            confirmPassword.requestFocus();
            check = false;
        }
        if(u_name.length()<10 || pass.length()<5 || c_pass.length()<5){
            check = false;
        }
        if(!pass.equals(c_pass)){
            confirmPassword.setError("Passwords not same");
            confirmPassword.requestFocus();
            check=false;
        }
        return check;
    }
}
