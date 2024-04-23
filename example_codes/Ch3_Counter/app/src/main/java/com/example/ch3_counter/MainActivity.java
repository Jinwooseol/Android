package com.example.ch3_counter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textview;
    int Count = 0;
    String counter = "카운터: ";
    int colorIndex = 0;
    int fontIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textview = (TextView)findViewById(R.id.textView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void increaseCounter(View v) {
        Count += 1;
        textview.setText(counter + Count);
    }
    public void decreaseCounter(View v) {
        Count -= 1;
        textview.setText(counter + Count);
    }
    public void initializeCounter(View v) {
        Count = 0;
        textview.setText(counter + Count);
    }
}