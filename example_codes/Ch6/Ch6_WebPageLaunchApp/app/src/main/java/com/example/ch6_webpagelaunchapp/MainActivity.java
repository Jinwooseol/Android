package com.example.ch6_webpagelaunchapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("WebPageLaunchApp", "onCreate");

        Intent receivedintent = getIntent();
        Uri uri = receivedintent.getData();
        URL webPageURL = null;

        if (uri != null) {
            try {
                webPageURL = new URL(uri.getScheme(), uri.getHost(), uri.getPath());
            } catch (Exception e) {
                Toast.makeText(this, "Intent exception occured", Toast.LENGTH_LONG).show();
            }
            WebView webView = findViewById(R.id.webView);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(webPageURL.toString());
        }


    }
}