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
        setContentView(R.layout.activity_main);

        Address original_address = new Address("Busan", "Dongrae");
        Person original_person = new Person("Felix", 26, original_address);
        try {
            Person clone_person = (Person) original_person.clone();
            //Person clone_person = original_person;

            Log.d("CloneableExample", "Original: " + original_person.toString());
            Log.d("CloneableExample", "Clone: " + clone_person.toString());

            clone_person.setName("Bob");
            clone_person.setAge(30);
            clone_person.setAddress(new Address("Seoul", "Gangnam"));

            Log.d("CloneableExample", "Original: " + original_person.toString());
            Log.d("CloneableExample", "Clone: " + clone_person.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}