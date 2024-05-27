package com.example.ch12_filetest02;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    String FILENAME = "test.txt";
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED) == false) {
            Toast.makeText(this, "외부 스토리지 실패",
                    Toast.LENGTH_SHORT).show();
        }
        edit = findViewById(R.id.editText);
        Button readButton = findViewById(R.id.readButton);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getExternalFilesDir(null), FILENAME);
                try {
                    InputStream is;
                    is = new FileInputStream(file);
                    byte[] buffer = new byte[is.available()];
                    is.read(buffer);
                    edit.setText(new String(buffer));
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Button writeButton = findViewById(R.id.writeButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getExternalFilesDir(null), FILENAME);
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(edit.getText().toString().getBytes());
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}