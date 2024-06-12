package com.example.ch15_mappolyline;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final LatLng SEOUL = new LatLng(37.566535, 126.977969);
    private static final LatLng DAEJEON = new LatLng(36.350412, 127.384548);
    private static final LatLng BUSAN = new LatLng(35.179554, 129.075642);
    private static final LatLng SUWEON = new LatLng(37.263573, 127.028601);
    private static final LatLng KWANGJU = new LatLng(35.159545, 126.852601);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().
                findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addPolyline((new PolylineOptions())
                .add(SEOUL, BUSAN, DAEJEON));

        mMap.addPolygon(new PolygonOptions()
                .addAll(createRectangle(SEOUL, 0.5, 0.5))
                .addHole(createRectangle(SUWEON, 0.1, 0.1))
                .fillColor(Color.YELLOW)
                .strokeColor(Color.BLUE)
                .strokeWidth(5));

        // 지도의 중심을 서울로 이동
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
    }

    /**
     * 주어진 치수로 사각형을 형성하는 위도/경도 리스트 생성
     */
    private List<LatLng> createRectangle(LatLng center, double halfWidth, double halfHeight) {
        return Arrays.asList(
                new LatLng(center.latitude - halfHeight, center.longitude - halfWidth),
                new LatLng(center.latitude - halfHeight, center.longitude + halfWidth),
                new LatLng(center.latitude + halfHeight, center.longitude + halfWidth),
                new LatLng(center.latitude + halfHeight, center.longitude - halfWidth),
                new LatLng(center.latitude - halfHeight, center.longitude - halfWidth));
    }
}