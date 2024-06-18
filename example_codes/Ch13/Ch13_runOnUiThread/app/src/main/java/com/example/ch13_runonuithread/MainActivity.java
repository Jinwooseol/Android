package com.example.ch13_runonuithread;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    private int mProgressStatus = 0;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = findViewById(R.id.progress_bar);
        mProgress.setMax(100);
        mProgress.setProgress(0);

        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    mProgressStatus = i++;

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();
    }
}