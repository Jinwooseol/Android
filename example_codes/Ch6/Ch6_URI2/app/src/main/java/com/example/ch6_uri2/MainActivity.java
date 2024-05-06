package com.example.ch6_uri2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri uri = Uri.parse("https://gw.optolane.com/login?returnUrl=%2Fapp%2Fhome");
        Intent
        Log.d("URI", "Uri : " + intent.getData());
        getContent
    }
}