package com.example.admin.camerademo;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {

    private BluetoothAdapter blutoothAdapter;
    private TextView tvinfo;
    private WifiManager wifiManager;
    private View view;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

    }

    public void initializedBluetooth() {

        blutoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!blutoothAdapter.isEnabled()) {
            enableBluetooth();
        } else {
            tvinfo.setText("Address" + blutoothAdapter.getAddress() + "\n Name" + blutoothAdapter.getName());
        }

        blutoothAdapter.startDiscovery();
        getPairedDevice();
        scanDevice();

    }

    private void enableBluetooth() {
        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableBtIntent, 300);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button btnclickhere = (Button) findViewById(R.id.btnclickhere);
        tvinfo = (TextView) findViewById(R.id.tvinfo);

        btnclickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializedBluetooth();
               // initializedWifi();
                //wifiManager.setWifiEnabled(true);
            }
        });
    }

    public void getPairedDevice() {
        Set<BluetoothDevice> pairedDevice = blutoothAdapter.getBondedDevices();
        if (pairedDevice.size() > 0) {
            for (BluetoothDevice device : pairedDevice) {
               ///String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress();
               // Log.i("ppp", "getPairedDevice: " + deviceName);


            }

        }

    }

    private void scanDevice() {
        blutoothAdapter.startDiscovery();
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(broadcastReceiver, intentFilter);

    }

    public void initializedWifi() {
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            BluetoothDevice device  =intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

            Log.i("TAG", "onReceive: "+device.getName());
        }
    };
}

