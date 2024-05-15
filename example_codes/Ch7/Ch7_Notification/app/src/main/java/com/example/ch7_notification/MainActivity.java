package com.example.ch7_notification;

import static android.Manifest.permission.POST_NOTIFICATIONS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.edit);
        if (ContextCompat.checkSelfPermission(this, POST_NOTIFICATIONS) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{POST_NOTIFICATIONS}, 1);
        }
        createNotificationChannel();
    }
    String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    "My Notifications",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Channel description");
            NotificationManager notificationManager = (NotificationManager)
                    getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
    public void sendNotification() {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,
                NOTIFICATION_CHANNEL_ID);
        Log.i("Notification", "sendNotification");
        // 알림이 클릭되면 해당 인텐트가 보내짐
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                intent, PendingIntent.FLAG_IMMUTABLE);
        notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Egg Timer")
                .setContentText("계란 삶기가 완료되었습니다.")
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build()); // 1은 notification ID
    }
    public void startTimer (View view) {
        mEditText.setText("00:05");
        String s = mEditText.getText().toString();
        int min = Integer.parseInt(s.substring(0, 2));
        int sec = Integer.parseInt(s.substring(3, 5));
        new CountDownTimer(min * 60 * 1000 + sec * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                mEditText.setText("" + (int)(millisUntilFinished / 1000) + "초");
            }
            public void onFinish() {
                mEditText.setText("done!");
                sendNotification();
            }
        }.start();
    }
}