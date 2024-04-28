package com.example.ch5_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout)findViewById(R.id.layout);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        if((view.getId() == R.id.radio_red) && (checked)) {
            layout.setBackgroundColor(Color.RED);
        } else if ((view.getId() == R.id.radio_blue) && (checked)) {
            layout.setBackgroundColor(Color.BLUE);
        }
    }
}