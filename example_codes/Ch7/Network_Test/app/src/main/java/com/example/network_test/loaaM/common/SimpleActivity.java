package com.example.network_test.loaaM.common;

import android.util.Log;

import com.example.network_test.loaaM.utils.NetworkUtil;

public class SimpleActivity {

    protected void onServerSendDataAnimalHeartBeat() {
        boolean isNetworkConnected = NetworkUtil.isConnected(this);
        if(!isNetworkConnected) {
            Log.i("TAG", "네트워크 미연결 상태 = HeartBeat 전송하지 않음");
            return;
        }

        String serialNumber = "";
        String loginID = "";


    }
}
