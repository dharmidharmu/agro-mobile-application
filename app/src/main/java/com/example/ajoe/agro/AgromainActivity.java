package com.example.ajoe.agro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import prefs.UserSession;

import com.example.ajoe.agro.activities.MainActivity;

public class AgromainActivity extends AppCompatActivity {
    Button signin,register;
    private UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agromain);
        signin = (Button)findViewById(R.id.b1);
        register = (Button)findViewById(R.id.b2);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AgromainActivity.this,login.class);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AgromainActivity.this,SignUp.class);
                startActivity(i);

            }
        });


    }
}
