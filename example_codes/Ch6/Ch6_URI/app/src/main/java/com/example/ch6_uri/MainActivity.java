package com.example.ch6_uri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClicked(View view) {
        Uri uri;
        Intent intent = null;
        if (view.getId() == R.id.button1) {         // Google 페이지
            uri = Uri.parse("http://www.google.com");
            intent = new Intent(Intent.ACTION_VIEW, uri);
        } else if (view.getId() == R.id.button2) {  // Google Map
            uri = Uri.parse("geo:38.899533,-77.036476");
            intent = new Intent(Intent.ACTION_VIEW,uri);
        } else if (view.getId() == R.id.button3) {  // Google 길찾기
            uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=startLat%20startLng&daddr=endLat%20endLng&hl=en");
            intent = new Intent(Intent.ACTION_VIEW, uri);
        } else if (view.getId() == R.id.button4) {  // SMS 발송
            uri = Uri.parse("smsto:01076112484");
            intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra("sms_body", "The SMS text");
        } else if (view.getId() == R.id.button5) {  // MMS 발송
            uri = Uri.parse("content://media/external/images/media/23");
            intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra("sms_body", "The MMS text");
            intent.setType("image/png");
        } else if (view.getId() == R.id.button6) {  // 이메일 발송
            uri = Uri.parse("mailto:felix@optolane.com");
            intent = new Intent(Intent.ACTION_SENDTO, uri);
        } else if (view.getId() == R.id.button7) {  // 설치 어플 제거

        } else if (view.getId() == R.id.button8) {  // Audio 재생
            uri = Uri.parse("file:///sdcard/download/everything.mp3");
            intent = new Intent(Intent.ACTION_VIEW, uri);
        } else if (view.getId() == R.id.button9) {  // 미디어 파일 재생

        } else if (view.getId() == R.id.button10) { // 마켓에서 검색
            uri = Uri.parse("market://search?q=pname:pkg_name");
            intent = new Intent(Intent.ACTION_VIEW, uri);
        } else if (view.getId() == R.id.button11) { // 마켓 어플 상세 화면

        } else if (view.getId() == R.id.button12) { // Google 검색
        } else if (view.getId() == R.id.button13) { // 전화 걸기

        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}