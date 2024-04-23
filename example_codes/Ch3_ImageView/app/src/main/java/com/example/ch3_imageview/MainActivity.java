package com.example.ch3_imageview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int scaleTypeIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void changeScaleType(View view) { // Scale Type 변경
        ImageView.ScaleType[] scaleTypes = {
                ImageView.ScaleType.CENTER,
                ImageView.ScaleType.CENTER_CROP,
                ImageView.ScaleType.CENTER_INSIDE,
                ImageView.ScaleType.FIT_CENTER,
                ImageView.ScaleType.FIT_XY,
        };
        imageView.setScaleType(scaleTypes[scaleTypeIndex]);
        scaleTypeIndex = (scaleTypeIndex + 1) % scaleTypes.length;
    }
    public void changeRotation(View view) {
        imageView.setRotation(imageView.getRotation() + 45);  // 45도씩 회전
    }
    public void changeAlpha(View view) {
        float alpha = imageView.getAlpha();
        alpha = (alpha == 1.0f) ? 0.5f : 1.0f;
        imageView.setAlpha(alpha);
    }
}