package com.example.newspaper;

import androidx.appcompat.app.AppCompatActivity;

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

public class SignupActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText edt_email, edt_password, edt_confirmPassword;
    Button btn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        edt_confirmPassword  = findViewById(R.id.conf_password);
        edt_email = findViewById(R.id.email);
        edt_password = findViewById(R.id.password);
        btn_reg = findViewById(R.id.btn_reg);

        TextView txt_register = findViewById(R.id.txt_login);
        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

        //create user
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(edt_email.getText().toString()) && !TextUtils.isEmpty(edt_password.getText().toString())
                && !TextUtils.isEmpty(edt_confirmPassword.getText().toString())){

                    if(edt_password.getText().toString().equals(edt_confirmPassword.getText().toString())){

                        mAuth.createUserWithEmailAndPassword(edt_email.getText().toString(),edt_password.getText().toString())
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {

                                        Toast.makeText(SignupActivity.this, "User register successfully! ", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                                        finish();
                                    }
                                });
                    }else{
                        Toast.makeText(SignupActivity.this, "Password must be same!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignupActivity.this, "Fields must not be empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}