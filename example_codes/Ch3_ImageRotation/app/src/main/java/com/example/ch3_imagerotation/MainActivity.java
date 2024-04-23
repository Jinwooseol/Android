package com.example.ch3_imagerotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText edittext;
    private ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext = (EditText)findViewById(R.id.rotationDegreeText);
        imageview = (ImageView)findViewById(R.id.imageView);
    }

    public void rotationClicked(View view) {
        String str_rotation_deg = edittext.getText().toString();
        int rotation_deg = Integer.parseInt(str_rotation_deg);

        imageview.setRotation(rotation_deg);
    }
}