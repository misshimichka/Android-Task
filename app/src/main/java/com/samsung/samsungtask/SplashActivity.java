package com.samsung.samsungtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.samsung.samsungtask.auth.CreateUserActivity;
import com.samsung.samsungtask.services.AuthService;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (AuthService.isSignIn()) {
            startActivity(new Intent(this, MainActivity.class));
        } else  {
            startActivity(new Intent(this, CreateUserActivity.class));
        }
        // TODO
    }
}