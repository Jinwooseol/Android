package com.example.ch13_threadgame1;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button gameButton;
    private TextView scoreTextView;
    private RelativeLayout layout;
    private int score = 0;
    private Handler handler = new Handler();
    private Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameButton = findViewById(R.id.gameButton);
        scoreTextView = findViewById(R.id.scoreTextView);
        layout = findViewById(R.id.layout);
        
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                scoreTextView.setText("점수: " + score);
                changeButtonPosition();
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeButtonPosition();
            }
        }, 3000);
    }
    private void changeButtonPosition() {
        int screenWidth = layout.getWidth();
        int screenHeight = layout.getHeight();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.leftMargin = random.nextInt(screenWidth - gameButton.getWidth());
        params.topMargin = random.nextInt(screenHeight - gameButton.getHeight());

        gameButton.setLayoutParams(params);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeButtonPosition();
            }
        }, 3000);
    }
    
}