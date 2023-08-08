package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AeroplaneModeChangeReciver aeroplaneModeChangeReciver = new AeroplaneModeChangeReciver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStart(){
        super.onStart();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(aeroplaneModeChangeReciver, filter);
    }

    protected  void stop(){
        super.onStop();
        unregisterReceiver(aeroplaneModeChangeReciver);
    }
}