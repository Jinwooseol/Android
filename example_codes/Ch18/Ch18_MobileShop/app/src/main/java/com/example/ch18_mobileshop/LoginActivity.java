package com.example.ch18_mobileshop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class LoginActivity extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private TextView statusText;
    private Button loginButton;
    String username, password;
    String line;
    StringBuilder response = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        statusText = findViewById(R.id.loginStatus);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = emailEditText.getText().toString();
                password = passwordEditText.getText().toString();
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final boolean success = isUserValid(username, password);
                // UI 업데이트를 위한 메인 thread로 전환
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onLoginResult(success);
                    }
                });
            }
        }).start();
    }

    private boolean isUserValid(String username, String password) {
        return true;
//        try {
//            String serverUrl = "http://10.0.2.2:8080/SHOP/login.jsp";
//            String queryParams = "username=" + URLEncoder.encode(username, "UTF-8")
//                    + "&password=" + URLEncoder.encode(password, "UTF-8");
//            // URL에 쿼리 parameter 추가
//            URL url = new URL(serverUrl + "?" + queryParams);
//            // GET 요청 설정
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//
//            response = new StringBuilder();
//
//            // GET 요청 수행
//            try (BufferedReader reader = new BufferedReader(
//                        new InputStreamReader(
//                                connection.getInputStream()
//                        ))) {
//                    String line;
//                    while((line = reader.readLine())!=null)
//
//                    {
//                        response.append(line);
//                    }
//                    // 서버로부터 받은 응답 처리
//                    if("success".equals(response.toString().trim())) {
//                        return true;
//                    }
//                } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
    }

    public void onLoginResult(boolean success) {
        // 로그인 결과에 따른 처리 수행
        if (success) {
            // 로그인 성공
            SharedPreferences sharedPreferences = getSharedPreferences("user_session",
                    Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("user_id", username);  // 사용자 정보 저장
            // 메인 화면으로 이동
            editor.apply();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            statusText.setText("로그인 실패!" + response.toString() + " " + username + " " + password);
        }
    }
}
