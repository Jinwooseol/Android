package com.example.ch3_randomnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRandomNumber = findViewById(R.id.textViewRandomNumber);
    }
    public void generateRandomNumber(View view) {
        Random random = new Random();
        int randomNumber = random.nextInt(100); // 0 ~ 99 까지의 random number 생성

        // TextView에 random number 표시
        textViewRandomNumber.setText("난수: " + randomNumber);
    }
}
