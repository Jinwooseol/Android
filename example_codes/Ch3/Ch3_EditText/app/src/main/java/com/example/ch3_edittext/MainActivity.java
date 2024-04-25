package com.example.ch3_edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextPhoneNumber;
    private TextView textViewUserInfo;
    EditText eText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        textViewUserInfo = (TextView) findViewById(R.id.textView);
    }
    
    public void onSignupButtonClick(View v) {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();

        String userInfo = "아이디: " + username + "\n패스워드: " + password + "\n전화번호: " + phoneNumber;
        textViewUserInfo.setText(userInfo);
    }
    
}