package com.example.ch11_usingcontent;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.Manifest;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Cursor cursor;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.picture);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }
    public void displayFirstImage(View v) {
        Toast.makeText(getApplicationContext(), "displayFirstImage()",
                Toast.LENGTH_LONG).show();
        try {
            String[] projection = new String[] {
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.DATA
            };
            cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    projection, null, null, null);
            int size = cursor.getCount();
            if (size == 0) {
                Toast.makeText(getApplicationContext(), "장치에 이미지가 없음!",
                         Toast.LENGTH_LONG).show();
            } else {
                if (cursor.moveToFirst()) {
                    String imageLocation = cursor.getString(1);
                    Toast.makeText(getApplicationContext(), imageLocation,
                            Toast.LENGTH_LONG).show();
                    File imgaeFile = new File(imageLocation);
                    if (imgaeFile.exists()) {
                        Bitmap bm = BitmapFactory.decodeFile(imageLocation);
                        imageView.setImageBitmap(bm);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}