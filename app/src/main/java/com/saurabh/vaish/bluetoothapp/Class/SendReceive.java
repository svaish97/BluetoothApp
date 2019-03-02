package com.saurabh.vaish.bluetoothapp.Class;

//package com.saurabh.vaish.bluetoothapp.Class;
//
//import android.bluetooth.BluetoothSocket;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//public class SendReceive extends Thread {
//     BluetoothSocket bluetoothSocket;
//    InputStream inputStream;
//    OutputStream outputStream;
//
//    public SendReceive(BluetoothSocket socket){
//        bluetoothSocket=socket;
//
//        try {
//            inputStream=socket.getInputStream();
//            outputStream=socket.getOutputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void run(){
////        byte[] buffer = new byte[1024];
////        int bytes;                                for receiving
////        while(true){
////
////        }
//    }
//    public void write(byte[] bytes){
//        try {
//            outputStream.write(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//}


import android.annotation.SuppressLint;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;




public class SendReceive extends Thread {
    private final BluetoothSocket mmSocket;
    private final InputStream mmInStream;
    private final OutputStream mmOutStream;

//    @SuppressLint("HandlerLeak")
//    private Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            byte[] writeBuf = (byte[]) msg.obj;
//            int begin = (int)msg.arg1;
//            int end = (int)msg.arg2;
//
//            switch(msg.what) {
//                case 1:
//                    String writeMessage = new String(writeBuf);
//                    writeMessage = writeMessage.substring(begin, end);
//                    break;
//            }
//        }
//    };
    public SendReceive(BluetoothSocket socket,String sendString) {
        mmSocket = socket;
        InputStream tmpIn = null;
        OutputStream tmpOut = null;
        try {
            tmpIn = socket.getInputStream();
            tmpOut = socket.getOutputStream();
        } catch (IOException e) { }
        mmInStream = tmpIn;
        mmOutStream = tmpOut;
        write(sendString.getBytes());
        
    }
    public void run() {
        byte[] buffer = new byte[1024];
        int begin = 0;
        int bytes = 0;
//        while (true) {
//            try {
//                bytes += mmInStream.read(buffer, bytes, buffer.length - bytes);
////                for(int i = begin; i < bytes; i++) {
////                    if(buffer[i] == "#".getBytes()[0]) {
////                        mHandler.obtainMessage(1, begin, i, buffer).sendToTarget();
////                        begin = i + 1;
////                        if(i == bytes - 1) {
////                            bytes = 0;
////                            begin = 0;
////                        }
////                    }
////                }
//            } catch (IOException e) {
//                break;
//            }
//        }
    }
    public void write(byte[] bytes) {
        try {
            mmOutStream.write(bytes);
            Log.d("SV", "write: ");
        } catch (IOException e) { }
    }
    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) { }
    }
}
