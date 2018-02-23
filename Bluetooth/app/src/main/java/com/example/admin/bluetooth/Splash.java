package com.example.admin.bluetooth;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import static com.example.admin.bluetooth.R.id.container;

public class Splash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button chat=(Button) findViewById(R.id.btnchat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           // onFragment();

                Toast.makeText(getApplicationContext(),"click successfully",Toast.LENGTH_LONG).show();
            }
        });
        onShare();
    }


    public void onFragment(){


                FragmentManager fmanager=getFragmentManager();
                FragmentTransaction ftransaction=fmanager.beginTransaction();
                ftransaction.add(R.id.container, ChatFragment1.newInstance("",""));
                ftransaction.commit();
                Log.i("Priyanka", "onFragment: Hello");


    }
    private void onShare(){
        Button share=(Button) findViewById(R.id.btnshare);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Share.class);
                startActivity(intent);
               // intent.putExtra("abc",)

            }
        });

    }



}
