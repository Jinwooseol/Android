package com.example.ch5_tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText)findViewById(R.id.editTextNumber);
    }
    public void onClicked(View view) {
        if (view.getId() == R.id.button) {
            RadioButton celsiusButton = (RadioButton) findViewById(R.id.celsius);
            RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.fahrenheit);

            if (text.getText().length() == 0) {
                Toast.makeText(this, "정확한 값을 입력하시오.", Toast.LENGTH_LONG).show();
                return;
            }

            float inputValue = Float.parseFloat(text.getText().toString());
            if (celsiusButton.isChecked()) {
                text.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
                celsiusButton.setChecked(false);
                fahrenheitButton.setChecked(true);
            } else {
                text.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
                celsiusButton.setChecked(true);
                fahrenheitButton.setChecked(false);
            }
        }
    }
    private float convertFahrenheitToCelsius(float fahrenheit) {
        return (float)((fahrenheit - 32) * 5 / 9.0);
    }
    private float convertCelsiusToFahrenheit(float celsius) {
        return (float)(((celsius * 9) / 5) + 32.0);
    }
}