package com.example.ch14_networktest1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button get = findViewById(R.id.get);
        display = findViewById(R.id.display);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ConnectivityManager manager = (ConnectivityManager)
                            getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo activeNet = manager.getActiveNetworkInfo();
                    if (activeNet != null) {
                        if (activeNet.getType() == ConnectivityManager.TYPE_WIFI) {
                            display.setText(activeNet.toString());
                        } else if (activeNet.getType() == ConnectivityManager.TYPE_MOBILE) {
                            display.setText(activeNet.toString());
                        }
                    }
                } catch (Exception e) {
                }
            }
        });
    }
}