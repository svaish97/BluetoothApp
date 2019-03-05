package com.saurabh.vaish.bluetoothapp

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_bluetooth.*

class ListBluetooth : AppCompatActivity() {
    lateinit var madapter:BluetoothAdapter
    val listOfBluetoothDevice= ArrayList<String>()
    val listOfAddress=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_bluetooth)
        madapter= BluetoothAdapter.getDefaultAdapter()
        if(madapter==null){
            Toast.makeText(baseContext,"Your Phone doesn't support Bluetooth", Toast.LENGTH_SHORT).show()
        }

        if(!madapter.isEnabled){
            val intent= Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivity(intent)
        }
        val pairedDevices:Set<BluetoothDevice>?=madapter.bondedDevices

        pairedDevices?.forEach {
            val deviceName=it.name
            val address=it.address
            listOfBluetoothDevice.add(deviceName)
            Log.d("SV", "$deviceName $address")
            listOfAddress.add(address)
        }



        val adapter=ArrayAdapter<String>(baseContext,android.R.layout.simple_list_item_1,
            android.R.id.text1,listOfBluetoothDevice)
        lv_devices.adapter=adapter

        lv_devices.setOnItemClickListener { adapterView, view, i, l ->
            val address=listOfAddress[i]
//            Log.d("DeviceAddress",address)
            val intent = Intent(baseContext,MainActivity::class.java)
            intent.putExtra("DeviceAddress",address)
            startActivity(intent)
            finish()
        }




    }
}
