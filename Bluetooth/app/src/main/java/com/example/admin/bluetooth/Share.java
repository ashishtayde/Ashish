package com.example.admin.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.List;

public class Share extends AppCompatActivity {
    private static final int DISCOVER_DURATION=300;
    private static final int REQUEST_BLU=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
    }
    public void sendViaBluetooth(View v){
        BluetoothAdapter btAdapter=BluetoothAdapter.getDefaultAdapter();
        if (btAdapter==null){
            Toast.makeText(getApplicationContext(),"Bluetooth not supported on this device",Toast.LENGTH_LONG).show();
        }
        else {
            enableBluetooth();
        }
    }

    private void enableBluetooth() {
        Intent discoveryIntent= new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoveryIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,DISCOVER_DURATION);
        startActivityForResult(discoveryIntent,REQUEST_BLU);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==DISCOVER_DURATION && requestCode==REQUEST_BLU){
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            File f=new File(Environment.getExternalStorageDirectory(),"priyanka.mp3");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(f));
            PackageManager pm=getPackageManager();
            List<ResolveInfo> appsList=pm.queryIntentActivities(intent,0);
            if (appsList.size()>0){
                String packageName=null;
                String className=null;
                boolean found=false;
                for (ResolveInfo info:appsList){
                    packageName=info.activityInfo.packageName;
                    if (packageName.equals("com.android.bluetooth")){
                        className=info.activityInfo.name;
                        found=true;
                        intent.setClassName(packageName,className);
                        startActivity(intent);
                        break;
                    }
                /* if (!found){
                      Toast.makeText(getApplicationContext(),"this device havn't be bluetooth",Toast.LENGTH_LONG).show();
                  }else {
                      intent.setClassName(packageName,className);
                      startActivity(intent);
                  }*/
                }
            }else {
                Toast.makeText(getApplicationContext(),"Bluetooth not supported",Toast.LENGTH_LONG).show();
            }
        }
    }

}
