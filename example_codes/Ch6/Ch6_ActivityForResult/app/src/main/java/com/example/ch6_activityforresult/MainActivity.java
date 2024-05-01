package com.example.ch6_activityforresult;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText idEditText, passwordEditText;
    private TextView statusText;
    private Button loginButton;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEditText = findViewById(R.id.idEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        statusText = findViewById(R.id.loginStatus);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ID, Password 입력 값 가져오기
                String id = idEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // SecondActivity로 전환하면서 ID, Password 데이터 전달
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("ID", id);
                intent.putExtra("Password", password);
                launcher.launch(intent);
            }
        });
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        statusText.setText(data.getStringExtra("status"));
                    }
                });
    }
}