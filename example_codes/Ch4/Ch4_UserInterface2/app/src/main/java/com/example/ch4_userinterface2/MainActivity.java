package com.example.ch4_userinterface2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mainLayout;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextView를 동적으로 생성하고 설정
                TextView textView = new TextView(MainActivity.this);
                textView.setText("동적으로 추가된 텍스트 뷰");

                // Layout 파라미터를 설정하여 Layout에 추가
                LinearLayout.LayoutParams layoutParams =
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT );
                textView.setLayoutParams(layoutParams);

                mainLayout.addView(textView);
            }
        });
    }
}