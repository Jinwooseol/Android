package com.example.ch6_splash;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.login);
        Log.i("LifeCycle", "LoginActivity onCreate()");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.i("LifeCycle", "LoginActivity onStart()");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i("LifeCycle", "LoginActivity onResume()");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i("LifeCycle", "LoginActivity onPause()");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.i("LifeCycle", "LoginActivity onStop()");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "LoginActivity onDestroy()");
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("LifeCycle", "LoginActivity onSaveInstanceState()");
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("LifeCycle", "LoginActivity onRestoreInstanceState()");
    }
}
