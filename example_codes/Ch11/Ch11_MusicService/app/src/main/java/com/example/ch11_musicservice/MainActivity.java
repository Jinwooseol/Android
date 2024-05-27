package com.example.ch11_musicservice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MusicService";
    Button start, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
    }
    public void onClick(View view) {
        if (view.getId() == R.id.start) {
            Log.d(TAG, "onClick() start ");
            startService(new Intent(this, MusicService.class));
        } else if (view.getId() == R.id.stop) {
            Log.d(TAG, "onClick() stop ");
            stopService(new Intent(this, MusicService.class));
        }
    }
}