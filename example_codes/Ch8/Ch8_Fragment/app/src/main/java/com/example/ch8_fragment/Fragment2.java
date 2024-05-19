package com.example.ch8_fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    public Fragment2() {}
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("fragment2", "onAttach");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fragment2", "onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("fragment2", "onCreateView");
        return inflater.inflate(R.layout.fragment2, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("fragment2", "onViewCreated");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment2", "onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment2", "onResume");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i("fragment2", "onPause");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment2", "onStop");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("fragment2", "onDestroyView");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fragment2", "onDestroy");
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment2", "onDetach");
    }


}
