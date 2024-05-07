package com.example.ch6_explicit_intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        Log.i("LifeCycle", "[Activity 2] onCreate()");
        Button b = (Button)findViewById(R.id.Button01);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 activity를 종료
                finish();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle", "[Activity 2] onStart()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeCycle", "[Activity 2] onRestart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle", "[Activity 2] onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle", "[Activity 2] onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle", "[Activity 2] onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "[Activity 2] onDestroy()");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("LifeCycle", "[Activity 2] onSaveInstanceState()");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("LifeCycle", "[Activity 2] onRestoreInstanceState()");
    }
}
