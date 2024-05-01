package com.example.ch5_electriccircuit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton1;
    private ToggleButton toggleButton2;
    private ImageView lightBulb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        lightBulb = (ImageView) findViewById(R.id.lightBulb);

        toggleButton1.setOnCheckedChangeListener(toggleListener);
        toggleButton2.setOnCheckedChangeListener(toggleListener);
    }
    private CompoundButton.OnCheckedChangeListener toggleListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            updateLightBulbState();
        }
    };
    private void updateLightBulbState() {
        boolean isToggle1On = toggleButton1.isChecked();
        boolean isToggle2On = toggleButton2.isChecked();

        if (isToggle1On && isToggle2On) {
            lightBulb.setImageResource(R.drawable.on);  // 두 토글 버튼이 모두 ON 상태일 때 전구 켜짐
        } else {
            lightBulb.setImageResource(R.drawable.off);
        }
    }
}