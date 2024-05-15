package com.example.ch8_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data = {"Apple", "Apricot", "Avocado", "Banana", "Blackberry",
                        "Blueberry", "Cherry", "Coconut", "Cranberry", "Grape Raisin",
                        "Honeydew", "Jackfruit", "Lemon", "Lime", "Mango", "Watermelon"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = data[position];
                Toast.makeText(getApplicationContext(), "선택한 항목: " + selectedItem,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}