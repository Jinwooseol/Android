package com.example.ch6_explicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        Button b = (Button)findViewById(R.id.Button01);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Activity2의 class 이름을 인수로 주어서 인텐트 객체를 생성 (명시적 인텐트)
                Intent intent = new Intent(Activity1.this, Activity2.class);
                // Activity2를 시작
                startActivity(intent);
            }
        });
    }
}