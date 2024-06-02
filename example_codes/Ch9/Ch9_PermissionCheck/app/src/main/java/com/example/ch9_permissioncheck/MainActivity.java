package com.example.ch9_permissioncheck;

import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "PermissionChecker";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermissions();
    }

    private void checkPermissions() {
        String[] permissions = {
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_FINE_LOCATION
        };

        for (String permission : permissions) {
            try {
                int protectionLevel = getPackageManager()
                        .getPermissionInfo(permission, PackageManager.GET_META_DATA)
                        .protectionLevel;

                if ((protectionLevel & PermissionInfo.PROTECTION_DANGEROUS) != 0) {
                    Log.d(TAG, permission + " is a runtime permission.");
                } else {
                    Log.d(TAG, permission + " is an install-time permission.");
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "Permission not found: " + permission, e);
            }
        }
    }
}