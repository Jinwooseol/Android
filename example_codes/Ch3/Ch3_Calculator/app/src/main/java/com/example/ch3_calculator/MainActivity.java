package com.example.ch3_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private EditText editTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextNumber1 = (EditText) findViewById(R.id.editTextNumber1);
        editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        editTextResult = (EditText) findViewById(R.id.editTextResult);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void plusOnClicked(View v) {
        String str_num1 = editTextNumber1.getText().toString();
        String str_num2 = editTextNumber2.getText().toString();

        int result = Integer.parseInt(str_num1) + Integer.parseInt(str_num2);
        String str_result = Integer.toString(result);
        editTextResult.setText(str_result);
    }

    public void minusOnClicked(View v) {
        String str_num1 = editTextNumber1.getText().toString();
        String str_num2 = editTextNumber2.getText().toString();

        int result = Integer.parseInt(str_num1) - Integer.parseInt(str_num2);
        String str_result = Integer.toString(result);
        editTextResult.setText(str_result);
    }

    public void multiplyOnClicked(View v) {
        String str_num1 = editTextNumber1.getText().toString();
        String str_num2 = editTextNumber2.getText().toString();

        int result = Integer.parseInt(str_num1) * Integer.parseInt(str_num2);
        String str_result = Integer.toString(result);
        editTextResult.setText(str_result);
    }

    public void divideOnClicked(View v) {
        String str_num1 = editTextNumber1.getText().toString();
        String str_num2 = editTextNumber2.getText().toString();
        int num1 = Integer.parseInt(str_num1);
        int num2 = Integer.parseInt(str_num2);
        String str_result = "";

        if (num2 == 0) {
            str_result = "num2 is 0. Can't divide";

        } else {
            double result = (double)num1/num2;
            str_result = String.format("%.2f", result);
        }

        editTextResult.setText(str_result);
    }

}