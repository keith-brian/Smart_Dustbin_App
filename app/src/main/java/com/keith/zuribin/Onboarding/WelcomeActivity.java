package com.keith.zuribin.Onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.keith.zuribin.Authentication.loginActivity;
import com.keith.zuribin.Authentication.signupActivity;
import com.keith.zuribin.R;

public class WelcomeActivity extends AppCompatActivity {

    LinearLayout linearlayout;
    Button btnSignin , btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnSignup = findViewById(R.id.btnWelcomeSignup);
        btnSignin = findViewById(R.id.btnWelcomeSignin);



       linearlayout = findViewById(R.id.welcomeLayout);

        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        linearlayout.setAnimation(slide_up);

        //

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, loginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WelcomeActivity.this, signupActivity.class);
                startActivity(intent);
                finish();

            }
        });





    }
}