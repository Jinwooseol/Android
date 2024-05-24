package com.example.ch9_cloneable;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Address original_address = new Address("Busan", "Dongrae");
        Person original_person = new Person("Felix", 26, original_address);
        try {
            Person clone_person = (Person) original_person.clone();

            Log.d("CloneableExample", "Original: " + original_person.toString());
            Log.d("CloneableExample", "Clone: " + clone_person.toString());



            Log.d("CloneableExample", "Original: " + original_person.toString());
            Log.d("CloneableExample", "Clone: " + clone_person.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}