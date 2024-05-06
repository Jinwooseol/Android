package com.example.receive_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

public class SecondActivity extends AppCompatActivity {
    WebView webView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Intent receivedIntent = getIntent();
        Uri uri = Uri.parse(receivedIntent.getStringExtra("Uri"));
        URL webPageURL = null;

        if (uri != null) {
            try {
                webPageURL = new URL(uri.getScheme(), uri.getHost(), uri.getPath());
            } catch (Exception e) {
                Toast.makeText(this, "Intent exception occured", Toast.LENGTH_LONG).show();
            }
            webView = findViewById(R.id.webView);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(webPageURL.toString());
        }
    }
}
