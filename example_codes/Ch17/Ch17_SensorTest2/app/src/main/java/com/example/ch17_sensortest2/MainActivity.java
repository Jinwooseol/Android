package com.example.ch17_sensortest2;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    float[] gravity, magnetic;
    float[] accels = new float[3];
    float[] mags = new float[3];
    float[] values = new float[3];
    float azimuth, pitch, roll;
    TextView text1;
    Sensor Accelerometer, Magnetometer;
    SensorManager sManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        text1 = findViewById(R.id.textView2);
        sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Accelerometer = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Magnetometer = sManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Accelerometer != null) {
            sManager.registerListener(this, Accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (Magnetometer != null) {
            sManager.registerListener(this, Magnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_MAGNETIC_FIELD:
                mags = event.values.clone();
                break;
            case Sensor.TYPE_ACCELEROMETER:
                accels = event.values.clone();
                break;
        }
        if (mags != null && accels != null) {
            gravity = new float[9];
            magnetic = new float[9];
            SensorManager.getRotationMatrix(gravity, magnetic, accels, mags);
            float[] outGravity = new float[9];
            SensorManager.remapCoordinateSystem(gravity, SensorManager.AXIS_X,
                    SensorManager.AXIS_Z, outGravity);
            SensorManager.getOrientation(outGravity, values);

            azimuth = values[2] * 180.0f / 3.14f;
            pitch = values[1] * 180.0f / 3.14f;
            roll = values[0] * 180.0f / 3.14f;
            mags = null;
            accels = null;
            text1.setText("Azimuth = " + azimuth + "\n"
                    + "Pitch = " + pitch + "\n"
                    + "Roll = " + roll);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}