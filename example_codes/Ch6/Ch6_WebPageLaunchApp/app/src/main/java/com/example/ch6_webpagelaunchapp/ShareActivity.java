package com.example.ch6_webpagelaunchapp;

import android.os.Build;
import android.os.StrictMode;

import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {
    protected void onCreated() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectUnsafeIntentLaunch()
                    .penaltyLog()
                    .build());
        }
    }
}
