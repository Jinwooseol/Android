package com.example.ch5_switch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private ImageView bulbImageView;
    private Switch switchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bulbImageView = (ImageView) findViewById(R.id.bulbImageView);
        switchButton = (Switch) findViewById(R.id.switchButton);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bulbImageView.setImageResource(R.drawable.on);
                } else {
                    bulbImageView.setImageResource(R.drawable.off);
                }
            }
        });
    }
}