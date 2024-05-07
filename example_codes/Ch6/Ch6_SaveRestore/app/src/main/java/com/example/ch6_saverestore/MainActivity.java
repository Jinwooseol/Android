package com.example.ch6_saverestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    TextView text;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LifeCycle", "onCreate()");
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                text.setText("현재 개수 = " + count);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                text.setText("현재 개수 = " + count);
            }
        });
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
            text.setText("현재 개수 = " + count);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.i("LifeCycle", "onStart()");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i("LifeCycle", "onResume()");
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("LifeCycle", "onSaveInstanceState()");
        outState.putInt("count", count);
    }
    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("LifeCycle", "onRestoreInstanceState()");
        int count = savedInstanceState.getInt("count");
        Log.i("LifeCycle", "Count : " + count);
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i("LifeCycle", "onPause()");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.i("LifeCycle", "onStop()");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "onDestroy()");
    }

}