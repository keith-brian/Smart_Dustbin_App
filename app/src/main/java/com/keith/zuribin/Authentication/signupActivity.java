package com.keith.zuribin.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
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
import com.keith.zuribin.R;

public class signupActivity extends AppCompatActivity {

    Button txtSignin, btncreateAccount;
    ImageView backArrow;

    EditText suEmail, suPassword;

    CircularProgressIndicator supIndicator;

    boolean isDataValid = false;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();


        backArrow = findViewById(R.id.subackArrow);
        txtSignin = findViewById(R.id.tvbtn_signin);
        btncreateAccount = findViewById(R.id.btnCreateAccount);

        suEmail = findViewById(R.id.edtxtsignup_email);
        suPassword = findViewById(R.id.edtxtsignup_password);

        supIndicator = findViewById(R.id.progressDialog);


        btncreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    performSignUp();

            }
        });




        txtSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signupActivity.this, loginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(signupActivity.this, loginActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }

    private void performSignUp() {

        String email = suEmail.getText().toString();
        String password = suPassword.getText().toString();


        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            btncreateAccount.setVisibility(View.GONE);
                            supIndicator.setVisibility(View.VISIBLE);

                            if (task.isSuccessful()) {

                                Toast.makeText(signupActivity.this, "Created Successfully!", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(signupActivity.this, DashboardActivity.class);
                                startActivity(intent);
                                finish();

                            } else {
                                Toast.makeText(signupActivity.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
                                btncreateAccount.setVisibility(View.VISIBLE);
                                supIndicator.setVisibility(View.GONE);
                            }


                        }
                    });

        }


    }


