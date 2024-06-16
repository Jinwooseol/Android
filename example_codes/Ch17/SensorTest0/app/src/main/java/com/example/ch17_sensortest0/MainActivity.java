package com.example.ch17_sensortest0;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String report = "";
        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_ALL);
        report += "전체 센서수: " + sensors.size() + "\n";
        int i = 0;
        for (Sensor s : sensors) {
            report += "" + i++ + " name: " + s.getName() + "\n"
                + "power: " + s.getPower() + "\n"
                + "res: " + s.getResolution() + "\n"
                + "range: " + s.getMaximumRange() + "\n\n";
        }
        TextView text = findViewById(R.id.text);

        text.setMovementMethod(new ScrollingMovementMethod());
        text.setText(report);
    }
}