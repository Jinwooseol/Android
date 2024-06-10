package com.example.ch13_galaga_game;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SpaceInvadersView spaceInvadersView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        spaceInvadersView = new SpaceInvadersView(this, size.x, size.y);
        setContentView(spaceInvadersView);
    }
    @Override
    protected void onResume() {
        super.onResume();
        spaceInvadersView.resume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        spaceInvadersView.pause();
    }
}