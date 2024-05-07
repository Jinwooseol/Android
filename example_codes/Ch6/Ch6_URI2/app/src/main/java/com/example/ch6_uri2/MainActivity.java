package com.example.ch6_uri2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText webSiteEditText;
    TextView schemeTextView, hostTextView, portTextView, pathTextView;
    Button button;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webSiteEditText = findViewById(R.id.webSiteEditText);
        schemeTextView = findViewById(R.id.schemeTextView);
        hostTextView = findViewById(R.id.hostTextView);
        portTextView = findViewById(R.id.portTextView);
        pathTextView = findViewById(R.id.pathTextView);
        button = findViewById(R.id.button);
        webView = findViewById(R.id.webView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String webSite = webSiteEditText.getText().toString();

                if (webSite != null) {
                    Uri uri = Uri.parse(webSite);
                    URL webPageURL = null;
                    String uriScheme = uri.getScheme();
                    String uriHost = uri.getHost();
                    int uriPort = uri.getPort();
                    String uriPath = uri.getPath();
                    schemeTextView.setText("Scheme : " + uriScheme);
                    hostTextView.setText("Host : " + uriHost);
                    portTextView.setText("Port : " + uriPort);
                    pathTextView.setText("Path : " + uriPath);

                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl(webSite);

                }
            }
        });
    }
}