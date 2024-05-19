package com.example.ch8_fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    public Fragment1() {}
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("Fragment1", "onAttach");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Fragment1", "onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        Log.i("Fragment1", "onCreateView");
        return inflater.inflate(R.layout.fragment1, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("Fragment1", "onViewCreated");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.i("Fragment1", "onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i("Fragment1", "onResume");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i("Fragment1", "onPause");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.i("Fragment1", "onStop");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("Fragment1", "onDestroyView");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Fragment1", "onDestroy");
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Fragment1", "onDetach");
    }

}
