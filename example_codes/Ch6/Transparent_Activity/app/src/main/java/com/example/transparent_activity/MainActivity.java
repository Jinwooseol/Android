package com.example.transparent_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LifeCycle", "[Activity 1] onCreate()");
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle", "[Activity 1] onStart()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeCycle", "[Activity 1] onRestart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle", "[Activity 1] onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle", "[Activity 1] onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle", "[Activity 1] onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "[Activity 1] onDestroy()");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("LifeCycle", "[Activity 1] onSaveInstanceState()");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("LifeCycle", "[Activity 1] onRestoreInstanceState()");
    }
}