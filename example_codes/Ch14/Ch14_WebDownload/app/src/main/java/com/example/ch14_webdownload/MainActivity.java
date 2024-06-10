package com.example.ch14_webdownload;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView tView;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tView = findViewById(R.id.text);
    }
    public void onClick(View v) {
        if (isNetworkAvailable()) {
            EditText urlEdit = findViewById(R.id.url);
            url = urlEdit.getText().toString();

            // Background thread 생성 및 실행
            Thread downloadThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        final String result =downloadUrl(url);  // Background에서 URL 다운로드
                        tView.post(new Runnable() {
                            @Override
                            public void run() {
                                tView.setText(result);
                                Toast.makeText(getApplicationContext(), "성공",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                    } catch (Exception e) {
                        Log.d("Background Task", e.toString());
                    }
                }
            });
            downloadThread.start();
        } else {
            Toast.makeText(getBaseContext(), "Network is not Available",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // 네트워크 연결 가능 여부 확인
    private boolean isNetworkAvailable() {
        boolean available = false;
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            available = true;
        }
        return available;
    }

    // URL에서 데이터 다운로드
    private String downloadUrl(String strUrl) throws IOException {
        String s = null;
        byte[] buffer = new byte[1000];
        InputStream iStream = null;
        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            iStream = urlConnection.getInputStream();
            iStream.read(buffer);
            s = new String(buffer);
        } catch (Exception e) {
            Log.d("Exception download", e.toString());
        } finally {
            if (iStream != null) {
                iStream.close();
            }
        }
        return s;
    }

}