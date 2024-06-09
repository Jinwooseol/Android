package com.example.ch13_imagedownload;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    public String URL = "";
    EditText edittext;
    ImageView imageView;
    Button button;
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageview);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL = edittext.getText().toString();
                downloadImage(URL);
            }
        });
    }
    private void downloadImage(final String imageUrl) {
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setTitle("이미지 다운로드 예제");
        mProgressDialog.setMessage("이미지 다운로드 중입니다.");
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.show();

        Thread downloadThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream input = new java.net.URL(imageUrl).openStream();
                    final Bitmap bitmap = BitmapFactory.decodeStream(input);

                    // UI 업데이트를 View.post()를 사용하여 메인 스레드에서 수행
                    imageView.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(bitmap);
                            mProgressDialog.dismiss();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        downloadThread.start();
    }
}