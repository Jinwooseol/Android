package com.example.ch11_powerconnected;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver chargerReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        chargerReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(getApplication(), "전원이 연결되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        };
        registerReceiver(
                chargerReceiver,
                new IntentFilter(Intent.ACTION_POWER_CONNECTED)
        );
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(chargerReceiver);
    }
}