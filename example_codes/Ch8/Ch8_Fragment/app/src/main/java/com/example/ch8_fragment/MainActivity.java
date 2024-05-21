package com.example.ch8_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);

        FrameLayout container = findViewById(R.id.frame_container);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.fragment1, container, true);
    }
    public void setFrag1(View view) {
        Log.i("MainActivity", "setFragment1");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.frame_container, new Fragment1(), "one");
        ft.commitAllowingStateLoss();
    }
    public void setFrag2(View view) {
        Log.i("MainActivity", "setFragment2");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.frame_container, new Fragment2(), "two");
        ft.commitAllowingStateLoss();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop");
    }
    @Override
    protected void onDestroy() {
        Log.i("MainActivity", "onDestroy");
        super.onDestroy();
    }
}