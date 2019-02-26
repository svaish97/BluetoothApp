package com.saurabh.vaish.bluetoothapp

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var madapter:BluetoothAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        madapter= BluetoothAdapter.getDefaultAdapter()
        if(madapter==null){
            Toast.makeText(baseContext,"Your Phone doesn't support Bluetooth",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bluetooth_enable,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==R.id.enableBluetooth){
            if(!madapter.isEnabled){
                val intent=Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivity(intent)
            }
            else{
                Toast.makeText(baseContext,"Bluetooth is enabled",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
