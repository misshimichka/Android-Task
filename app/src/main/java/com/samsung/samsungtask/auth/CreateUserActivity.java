package com.samsung.samsungtask.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.samsung.samsungtask.MainActivity;
import com.samsung.samsungtask.R;
import com.samsung.samsungtask.services.AuthService;

import java.util.HashMap;
import java.util.Objects;

public class CreateUserActivity extends AppCompatActivity {
    Button toLogInButton;
    Button registerButton;
    EditText emailEditText;
    EditText passwordEditText;
    TextView textView;
    TextView emailTextView;
    TextView passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        initViews();

        toLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), LogInActivity.class));
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. get values
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                //2. check values
                if (email.isEmpty()) {
                    emailEditText.setError("Email is empty");
                    showMessage("Email is empty");
                    return;
                }
                if (!email.contains("@") || email.length() < 3) {
                    emailEditText.setError("Password must be correct");
                    showMessage("Password must be correct");
                    return;
                }

                if (password.isEmpty()) {
                    passwordEditText.setError("Password is empty");
//                    showMessage("Password is empty");
                    return;
                }
                if (password.length() < 6) {
                    passwordEditText.setError("Password must be correct");
//                    showMessage("Password must be correct");
                    return;
                }

                //3. do with values
                ProgressDialog bar = createPD();
                bar.setTitle("Loading");
                bar.show();

                AuthService.createUser(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(getBaseContext(), MainActivity.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        showMessage("Can't create user");
                        e.printStackTrace();
                    }
                }).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        bar.dismiss();
                    }
                });
            }
        });


    }

    ProgressDialog createPD() {
        return new ProgressDialog(this);
    }

    void initViews() {
        textView = findViewById(R.id.textView);
        emailTextView = findViewById(R.id.emailTextView);
        passwordTextView = findViewById(R.id.passwordTextView);
        toLogInButton = findViewById(R.id.toLogInButton);
        registerButton = findViewById(R.id.registerButton);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
    }

    void showMessage(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}