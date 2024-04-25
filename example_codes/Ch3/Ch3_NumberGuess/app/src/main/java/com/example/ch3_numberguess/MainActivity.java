package com.example.ch3_numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText edittext;
    private TextView textview;

    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext = (EditText)findViewById(R.id.editText);
        textview = (TextView)findViewById(R.id.textView);
    }
    public void guessOnClicked(View view) {
        String str_guess = edittext.getText().toString();
        int guess_num = Integer.parseInt(str_guess);

        if (guess_num < randomNumber) {
            textview.setText("High!!!");
        } else if (guess_num > randomNumber) {
            textview.setText("Low!!!");
        } else {    // guess_num == randomNumber
            textview.setText("Correct!!!");
            randomNumber = random.nextInt(100) + 1;
        }
    }
}