package com.example.ch6_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_TIMEOUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LifeCycle", "MainActivity onCreate()");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                Log.i("LifeCycle", "MainActivity before startLoginActivity");
                startActivity(intent);
                Log.i("LifeCycle", "MainActivity after startLoginActivity");
                // Splash 화면 종료
                finish();
                Log.i("LifeCycle", "MainActivity after finish");
            }
        }, SPLASH_TIMEOUT);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("LifeCycle", "MainActivity onStart()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeCycle", "MainActivity onRestart()");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i("LifeCycle", "MainActivity onResume()");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i("LifeCycle", "MainActivity onPause()");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.i("LifeCycle", "MainActivity onStop()");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "MainActivity onDestroy()");
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("LifeCycle", "MainActivity onSaveInstanceState()");
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("LifeCycle", "MainActivity onRestoreInstanceState()");
    }
}