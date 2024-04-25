package com.example.ch3_diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageview;
    private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview = (ImageView)findViewById(R.id.imageView);
        textview = (TextView)findViewById(R.id.textView);
    }
    public void rollClicked(View view) {
        Random random = new Random();
        int randomNumber = random.nextInt(6);

        switch(randomNumber) {
            case 0:
                imageview.setImageResource(R.drawable.dice1);
                break;
            case 1:
                imageview.setImageResource(R.drawable.dice2);
                break;
            case 2:
                imageview.setImageResource(R.drawable.dice3);
                break;
            case 3:
                imageview.setImageResource(R.drawable.dice4);
                break;
            case 4:
                imageview.setImageResource(R.drawable.dice5);
                break;
            case 5:
                imageview.setImageResource(R.drawable.dice6);
                break;
        }
        textview.setText(Integer.toString(randomNumber + 1));
    }
}