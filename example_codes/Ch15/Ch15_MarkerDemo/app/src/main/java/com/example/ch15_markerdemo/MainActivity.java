package com.example.ch15_markerdemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements
        GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private static final LatLng SEOUL = new LatLng(37.566535, 126.977969);
    private static final LatLng DAEJEON = new LatLng(36.350412, 127.384548);
    private static final LatLng BUSAN = new LatLng(35.179554, 129.075642);
    private Marker mSeoul;
    private Marker mDaejeon;
    private Marker mBusan;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().
                findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * 지도가 준비되면 호출
     *
     * @param googleMap
     */
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mSeoul = mMap.addMarker(new MarkerOptions().position(SEOUL).title("서울"));
        mSeoul.setTag(0);
        mDaejeon = mMap.addMarker(new MarkerOptions().position(DAEJEON).title("대전").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant)));
        mDaejeon.setTag(0);
        mBusan = mMap.addMarker(new MarkerOptions().position(BUSAN).title("부산"));
        mBusan.setTag(0);
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
    }

    /**
     * 사용자가 마커를 클릭하면 호출
     *
     * @param marker
     * @return
     */
    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Integer clickCount = (Integer) marker.getTag();
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this, marker.getTitle() + " 가 클릭되었음, 클릭횟수: " + clickCount,
                    Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}