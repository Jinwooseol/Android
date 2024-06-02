package com.example.ch11_usingcontent2;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.provider.MediaStore;
import android.provider.UserDictionary;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Cursor cursor;
    Uri newUri;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView2);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    public void insert(View view) {
        String word = editText.getText().toString();

        ContentValues newValues = new ContentValues();
        newValues.put(UserDictionary.Words.APP_ID, "example.user");
        newValues.put(UserDictionary.Words.WORD, word);
        newValues.put(UserDictionary.Words.LOCALE, "en_US");
        newUri = getContentResolver().insert(UserDictionary.Words.CONTENT_URI, newValues);
        Toast.makeText(this, "단어 저장 완료 " + newUri, Toast.LENGTH_SHORT).show();
    }
    public void print(View view) {
        try {
            String[] projection = {
                    UserDictionary.Words._ID,
                    UserDictionary.Words.APP_ID,
                    UserDictionary.Words.WORD,
                    UserDictionary.Words.LOCALE
            };
            String[] selectionArgs = {""};
            cursor = getContentResolver().query(UserDictionary.Words.CONTENT_URI,
                    projection,
                    null,
                    selectionArgs,
                    null);
            String s = "AppID      Word      Locale \r\n";
            while (cursor.moveToNext()) {
                s += cursor.getString(1) + "    ";
                s += cursor.getString(2) + "    ";
                s += cursor.getString(3) + "    \r\n";
            }
            textView.setText(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}