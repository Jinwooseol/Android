package com.example.ch17_diceshaker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements SensorEventListener, TextToSpeech.OnInitListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private static float SHAKE_THRESHOLD = 5.0f;
    private TextToSpeech mTts;
    private TextView mNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumber = findViewById(R.id.number);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mTts = new TextToSpeech(this, this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onInit(int status) {
        if (status != TextToSpeech.ERROR) {
            mTts.setLanguage(getResources().getConfiguration().locale);
        }
    }
    @Override
    protected void onDestroy() {
        if (mTts != null) {
            mTts.stop();
            mTts.shutdown();
        }
        super.onDestroy();
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        y -= 9.8f;
        float acceleration = (float) Math.sqrt(x * x + y * y + z * z);
        if (acceleration > SHAKE_THRESHOLD) {
            generateRandomNumber();
        }
    }
    private void generateRandomNumber() {
        Random randomGenerator = new Random();
        int randomNum = randomGenerator.nextInt(6) + 1;
        mNumber.setText(Integer.toString(randomNum));
        mTts.speak(Integer.toString(randomNum), TextToSpeech.QUEUE_FLUSH, null);
    }
}