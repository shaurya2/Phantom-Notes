package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText edtUsername,edtEmail,edtPassword,edtConfirmPassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUsername= (EditText) findViewById(R.id.inputUsername);
        edtEmail= (EditText) findViewById(R.id.inputEmail);
        edtPassword= (EditText) findViewById(R.id.inputPassword);
        edtConfirmPassword= (EditText) findViewById(R.id.inputConfirmPassword);

        firebaseAuth=FirebaseAuth.getInstance();


        TextView btn=findViewById(R.id.alreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));


            }
        });
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username = edtUsername.getText().toString();
                String Email = edtEmail.getText().toString();
                String Password= edtPassword.getText().toString();
                String ConfirmPassword = edtConfirmPassword.getText().toString();

                if (Username.isEmpty() || Email.isEmpty() || Password.isEmpty() || ConfirmPassword.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "Please Fill all the Details", Toast.LENGTH_SHORT).show();
                }
                else if (Password.equals(ConfirmPassword))
                {
                    registerUser(Email,Password);
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Please Confirm Correct Password", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    private void registerUser(String Email, String Password) {
        firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    sendVerification();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Failed To Register", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {
                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendVerification() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull  Task<Void> task) {
                    Toast.makeText(RegisterActivity.this, "Verification Email is Sent,Verify and Login Again", Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull  Exception e) {
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }



}
