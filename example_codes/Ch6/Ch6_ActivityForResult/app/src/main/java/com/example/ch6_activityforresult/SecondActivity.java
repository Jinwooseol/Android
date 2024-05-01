package com.example.ch6_activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView displayIdTextView, displayPasswordTextView, statusTextView;
    private Button button;
    String id, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        displayIdTextView = findViewById(R.id.displayIdTextView);
        displayPasswordTextView = findViewById(R.id.displayPasswordTextView);
        statusTextView = findViewById(R.id.loginSuccess);
        button = findViewById(R.id.button);

        // Intent에서 ID와 비밀번호 데이터 가져오기
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("ID");
            password = intent.getStringExtra("Password");

            displayIdTextView.setText("아이디: " + id);
            displayPasswordTextView.setText("비밀번호: " + password);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (isUserValid(id, password)) {
                    intent.putExtra("status", "로그인 성공!!!!");
                } else {
                    intent.putExtra("status", "로그인 실패!!!!");
                }
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    private boolean isUserValid(String username, String password) {
        // 서버 또는 로컬 DataBase를 통해 인증을 확인
        return username.equals("Felix") && password.equals("1234");
    }
}
