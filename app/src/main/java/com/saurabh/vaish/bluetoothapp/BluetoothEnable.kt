package com.saurabh.vaish.bluetoothapp

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bluetooth_enable.*

class BluetoothEnable : AppCompatActivity() {
    lateinit var madapter: BluetoothAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth_enable)
        madapter= BluetoothAdapter.getDefaultAdapter()
        if(madapter==null){
            Toast.makeText(baseContext,"Your Phone doesn't support Bluetooth", Toast.LENGTH_SHORT).show()
        }
        if(madapter.isEnabled){
            val intent=Intent(this@BluetoothEnable,ListBluetooth::class.java)
            startActivity(intent)
            finish()
        }
        image.setOnClickListener {
            if(!madapter.isEnabled){
                val intent= Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(intent,123)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==123){
            if(resultCode== Activity.RESULT_OK){
                val intent=Intent(this@BluetoothEnable,ListBluetooth::class.java)
                startActivity(intent)
                finish()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
