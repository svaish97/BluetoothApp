package com.saurabh.vaish.bluetoothapp.Class;//package com.saurabh.vaish.bluetoothapp.Class;
//
//import android.bluetooth.BluetoothAdapter;
//import android.bluetooth.BluetoothServerSocket;
//import android.bluetooth.BluetoothSocket;
//
//import java.io.IOException;
//import java.util.UUID;
//
//
//
//public class BluetoothServer extends Thread {
//public static final String APP_NAME="BluetoothApp";
//public static final UUID MY_UUID=UUID.fromString("D1926A8C-BACD-402B-87EC-D5A29064CCF3");
//BluetoothAdapter madapter=BluetoothAdapter.getDefaultAdapter();
//public String stringToSend;
//
//BluetoothServerSocket serverSocket;
//public  BluetoothServer(String str){
//    stringToSend=str;
//    try {
//        serverSocket=madapter.listenUsingRfcommWithServiceRecord(APP_NAME,MY_UUID);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//public void run(){
//    BluetoothSocket socket=null;
//    while(socket==null){
//        try {
//            socket=serverSocket.accept();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (socket!=null){
//            SendReceive sendReceive;
//            sendReceive=new SendReceive(socket);
//            sendReceive.write(stringToSend.getBytes());
//            sendReceive.start();
//            break;
//        }
//    }
//}
//}

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

public class BluetoothServer extends Thread {
    private final BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;
    String sendString;
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    public BluetoothServer(BluetoothDevice device,String stringtoSend) {
        BluetoothSocket tmp = null;
        mmDevice = device;
        sendString=stringtoSend;
        try {
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException ignored) { }
        mmSocket = tmp;
    }
    public void run() {
//        mBluetoothAdapter.cancelDiscovery();
        try {
            mmSocket.connect();
        } catch (IOException connectException) {
            try {
                mmSocket.close();
            } catch (IOException ignored) { }
        }
        SendReceive mConnectedThread = new SendReceive(mmSocket,sendString);
//        mConnectedThread.start();
    }
    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException ignored) { }
    }
}
