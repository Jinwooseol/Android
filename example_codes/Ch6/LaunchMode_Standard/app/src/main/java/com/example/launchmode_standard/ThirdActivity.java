package com.example.launchmode_standard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    Button Act3ToAct1Button, Act3ToAct2Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.i("LifeCycle", "[Activity 3] onCreate()");
        Act3ToAct1Button = findViewById(R.id.Act3ToAct1Button);
        Act3ToAct2Button = findViewById(R.id.Act3ToAct2Button);
    }
    public void onClicked(View view) {
        if (view.getId() == R.id.Act3ToAct1Button) {
            Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.Act3ToAct2Button) {
            Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("LifeCycle", "[Activity 3] onNewIntent()");
    }
}
