package com.keith.zuribin.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.keith.zuribin.Onboarding.WelcomeActivity;
import com.keith.zuribin.R;

public class DashboardActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    Button signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mAuth = FirebaseAuth.getInstance();


        signout = findViewById(R.id.btnLogout);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Toast.makeText(DashboardActivity.this, "Signed out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashboardActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}