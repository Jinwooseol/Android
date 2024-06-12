package com.example.ch16_audioplay;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//    public void startResAudio(View view) {
//        mp = MediaPlayer.create(this, R.raw.old_pop);
//        mp.start();
//    }
    public void startResAudio(View view) {
        mp = new MediaPlayer();
        try {
            mp.setDataSource("D:\\Android\\example_codes\\Ch16\\old_pop.mp3");
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void stopResAudio(View view) {
        if (mp != null) {
            mp.stop();
            mp.release();
        }
        mp = null;
    }
}