package com.keith.zuribin.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.keith.zuribin.Authentication.signupActivity;

import com.keith.zuribin.Onboarding.WelcomeActivity;
import com.keith.zuribin.R;

public class loginActivity extends AppCompatActivity {

    Button textSignUp, btnLogin;
    EditText siEmail, siPassword;
    ImageView backArrow;
    CircularProgressIndicator siIndicator;

    FirebaseAuth mAuth;

    boolean isDataValid = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        siIndicator = findViewById(R.id.siIndicator);

        textSignUp = findViewById(R.id.btnSignUp);
        backArrow = findViewById(R.id.loginbackArrow);

        btnLogin = findViewById(R.id.btnLogin);


        siEmail = findViewById(R.id.edtxtlogin_email);
        siPassword = findViewById(R.id.edtxtlogin_password);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    performSignin();

            }
        });




        textSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, signupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();

            }
        });



    }

    private void performSignin() {

        String Email = siEmail.getText().toString();
        String Password = siPassword.getText().toString();


        mAuth.signInWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        btnLogin.setVisibility(View.GONE);
                        siIndicator.setVisibility(View.VISIBLE);

                        if(task.isSuccessful()){

                            Toast.makeText(loginActivity.this, "Signing Successful", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(loginActivity.this, DashboardActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(loginActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                            siIndicator.setVisibility(View.GONE);
                            btnLogin.setVisibility(View.VISIBLE);
                        }

                    }
                });




    }
}