package com.example.ch6_activity_launch_mode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    final static String STARTED_CNT = "STARTED_CNT";
    final static int RETRY_CNT = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("LifeCycle", "onCreate");
        int startedCnt = getIntent().getIntExtra(STARTED_CNT, 0);
        Intent recursiveIntent = new Intent(this, MainActivity.class);
        recursiveIntent.putExtra(STARTED_CNT, ++startedCnt);
        if (startedCnt < RETRY_CNT) {
            startActivity(recursiveIntent);
        }
    }
}