package com.example.launchmode_standard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Act1ToAct1Button, Act1ToAct2Button, Act1ToAct3Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LifeCycle", "[Activity 1] onCreate()");
        Act1ToAct1Button = findViewById(R.id.Act1ToAct1Button);
        Act1ToAct2Button = findViewById(R.id.Act1ToAct2Button);
        Act1ToAct3Button = findViewById(R.id.Act1ToAct3Button);
    }
    public void onClicked(View view) {
        if (view.getId() == R.id.Act1ToAct1Button) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.Act1ToAct2Button) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.Act1ToAct3Button) {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("LifeCycle", "[Activity 1] onNewIntent()");
    }
}