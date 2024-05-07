package com.example.launchmode_standard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class SecondActivity extends AppCompatActivity {
    Button Act2ToAct1Button, Act2ToAct3Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("LifeCycle", "[Activity 2] onCreate()");
        Act2ToAct1Button = findViewById(R.id.Act2ToAct1Button);
        Act2ToAct3Button = findViewById(R.id.Act2ToAct3Button);
    }
    public void onClicked(View view) {
        if (view.getId() == R.id.Act2ToAct1Button) {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.Act2ToAct3Button) {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("LifeCycle", "[Activity 2] onNewIntent()");
    }
}
