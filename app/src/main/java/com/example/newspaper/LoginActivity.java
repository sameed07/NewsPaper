package com.example.newspaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {


    FirebaseAuth mAuth;
    EditText edt_email, edt_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();


        edt_email = findViewById(R.id.email);
        edt_password = findViewById(R.id.password);
        btn_login = findViewById(R.id.login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setTitle("Signin in...");
                progressDialog.show();
                if(!TextUtils.isEmpty(edt_email.getText().toString()) && !TextUtils.isEmpty(edt_password.getText().toString())
                         ){



                        mAuth.signInWithEmailAndPassword(edt_email.getText().toString(),edt_password.getText().toString())
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {

                                        progressDialog.dismiss();
                                        Toast.makeText(LoginActivity.this, "User Login successfully! ", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this,LoginActivity.class));
                                        finish();
                                    }
                                });

                }else{
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Fields must not be empty!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        TextView txt_register = findViewById(R.id.txt_register);
        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    private void updateUI(FirebaseUser user) {

        if(user != null){

            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        else{

            // Toast.makeText(this, "Issue occur", Toast.LENGTH_SHORT).show();
        }

    }
}