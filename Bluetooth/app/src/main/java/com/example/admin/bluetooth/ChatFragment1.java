package com.example.admin.bluetooth;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChatFragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChatFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private View view;
    private BluetoothAdapter blutoothAdapter;
    private TextView tvinfo;
    private ListView lv;
    ArrayAdapter<String> adapter;
    private String[] paires;
    private static final int DISCOVER_DURATION=300;
    private static final int REQUEST_BLU=1;



    public ChatFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment1 newInstance(String param1, String param2) {
        ChatFragment1 fragment = new ChatFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }


    public void onfragment2(){
       FragmentManager fmanager=getFragmentManager();
       FragmentTransaction ftransaction=fmanager.beginTransaction();
       ftransaction.add(R.id.container2, ChatFragment2.newInstance("",""));
       ftransaction.commit();
       Log.i("Priyanka", "onFragment2: Hello");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_chat_fragment1, container, false);
    return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
      /*  if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

   /*public void initializedBluetooth() {

        blutoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!blutoothAdapter.isEnabled()) {
            enableBluetooth();
        } else {
            tvinfo.setText("Address" + blutoothAdapter.getAddress() + "\n Name" + blutoothAdapter.getName());
        }

        blutoothAdapter.startDiscovery();
scanDevice();
        getPairedDevice();
    }

    private void enableBluetooth() {
        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableBtIntent, 300);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button btnclickhere = (Button) view.findViewById(R.id.btnclickhere);
        tvinfo = (TextView) view.findViewById(R.id.tvinfo);

        btnclickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializedBluetooth();
            }
        });


    onfragment2();
    }

    public void getPairedDevice() {
        Set<BluetoothDevice> pairedDevice = blutoothAdapter.getBondedDevices();
         lv=(ListView) view.findViewById(R.id.listview);
        if (pairedDevice.size() > 0) {
            for (BluetoothDevice device : pairedDevice) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress();
                Bundle bn=new Bundle();
                paires=bn.getStringArray(String.valueOf(paires));
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,paires);
                lv.setAdapter(adapter);
                Log.i("ppp", "getPairedDevice: " + deviceName);
            }
        }


    }

    private void scanDevice() {
        blutoothAdapter.startDiscovery();
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(broadcastReceiver, intentFilter);

    }

    private void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
    }


    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            BluetoothDevice device  =intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

            Log.i("TAG", "onReceive: "+device.getName());
        }
    };*/
   @RequiresApi(api = Build.VERSION_CODES.M)
   public void sendViaBluetooth(View v){
       BluetoothAdapter btAdapter=BluetoothAdapter.getDefaultAdapter();
       if (btAdapter==null){
           Toast.makeText(getContext(),"Bluetooth not supported on this device",Toast.LENGTH_LONG).show();
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
                /*  if (!found){
                      Toast.makeText(getApplicationContext(),"this device havn't be bluetooth",Toast.LENGTH_LONG).show();
                  }else {
                      intent.setClassName(packageName,className);
                      startActivity(intent);
                  }*/
                }
            }else {
                Toast.makeText(getContext(),"Bluetooth not supported",Toast.LENGTH_LONG).show();
            }
        }
    }

    private PackageManager getPackageManager() {
        return null;
    }


}