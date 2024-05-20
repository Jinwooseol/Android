package com.example.ch10_reference_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = findViewById(R.id.textView);
        textView.setText(R.string.title_name);
        setContentView(R.layout.activity_main);
    }
}