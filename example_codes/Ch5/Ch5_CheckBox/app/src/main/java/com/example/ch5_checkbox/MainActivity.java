package com.example.ch5_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageview1, imageview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview1 = (ImageView)findViewById(R.id.imageView1);
        imageview2 = (ImageView)findViewById(R.id.imageView2);
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        if (view.getId() == R.id.checkBox1) {
            if (checked) imageview1.setImageResource(R.drawable.meat_sandwich);
            else imageview1.setImageResource(0);
        } else {
            if (checked) imageview2.setImageResource(R.drawable.cheese_sandwich);
            else imageview2.setImageResource(0);
        }
    }
}