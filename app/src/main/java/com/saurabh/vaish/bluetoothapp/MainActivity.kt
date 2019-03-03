package com.saurabh.vaish.bluetoothapp

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.io.OutputStream
import java.util.*



class MainActivity : AppCompatActivity() {
    var stringtoSend:String = ""
    lateinit var madapter:BluetoothAdapter
    lateinit var mdevice:BluetoothDevice
    lateinit var bluetoothSocket:BluetoothSocket
    lateinit var inputStream: InputStream
    lateinit var outputStream: OutputStream
    var stringResult: String=""
    val uuid=UUID.fromString("00001101-0000-1000-8000-00805f9b34fb")
    var boolean:Boolean=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        madapter= BluetoothAdapter.getDefaultAdapter()

        if(madapter.isEnabled) {
            mdevice = madapter.getRemoteDevice("00:15:83:35:97:C1")
            bluetoothSocket = mdevice.createRfcommSocketToServiceRecord(uuid)
        }

        val bluetoothServ = BluetoothServ()
        bluetoothServ.execute()

        one.setOnClickListener {
            stringtoSend="1"
            outputStream.write(stringtoSend.toByteArray())
            receive()

        }
        two.setOnClickListener {
            stringtoSend="2"
            outputStream.write(stringtoSend.toByteArray())
            receive()

        }
        three.setOnClickListener {
            stringtoSend="3"
            outputStream.write(stringtoSend.toByteArray())

        }
        four.setOnClickListener {
            stringtoSend="4"
            outputStream.write(stringtoSend.toByteArray())

        }
        five.setOnClickListener {
            stringtoSend="5"
            outputStream.write(stringtoSend.toByteArray())

        }
        six.setOnClickListener {
            stringtoSend="6"
            outputStream.write(stringtoSend.toByteArray())

        }
        seven.setOnClickListener {
            stringtoSend="7"
            outputStream.write(stringtoSend.toByteArray())

        }
        eight.setOnClickListener {
            stringtoSend="8"
            outputStream.write(stringtoSend.toByteArray())

        }
        nine.setOnClickListener {
            stringtoSend="9"
            outputStream.write(stringtoSend.toByteArray())

        }
        zero.setOnClickListener {
            stringtoSend="0"
            outputStream.write(stringtoSend.toByteArray())

        }
        A.setOnClickListener {
            stringtoSend="A"
            outputStream.write(stringtoSend.toByteArray())

        }
        B.setOnClickListener {
            stringtoSend="B"
            outputStream.write(stringtoSend.toByteArray())

        }
        C.setOnClickListener {
            stringtoSend="C"
            outputStream.write(stringtoSend.toByteArray())

        }
        D.setOnClickListener {
            stringtoSend="D"
            outputStream.write(stringtoSend.toByteArray())

        }
        star.setOnClickListener {
            stringtoSend="*"
            outputStream.write(stringtoSend.toByteArray())

        }
        hash.setOnClickListener {
            stringtoSend="#"
            outputStream.write(stringtoSend.toByteArray())

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

        if(item?.itemId==R.id.list_bluetooth){
            if(!madapter.isEnabled){
                val intent=Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivity(intent)
            }
            else{
             startActivity(Intent(baseContext,ListBluetooth::class.java))
            }

        }
        return super.onOptionsItemSelected(item)
    }

    inner class BluetoothServ:AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg p0: Void?): Void? {
            bluetoothSocket.connect()
            return null
        }

        override fun onPostExecute(result: Void?) {
            outputStream=bluetoothSocket.outputStream
            inputStream=bluetoothSocket.inputStream

            super.onPostExecute(result)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(resultCode==123){
            if(requestCode== Activity.RESULT_OK){

            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    public fun receive(){
        Receive().execute()

    }
    inner class Receive:AsyncTask<Void,Void,String?>(){
        override fun doInBackground(vararg p0: Void?): String? {
            var byte=ByteArray(1024)
            while(true){
                val value=inputStream.read(byte)
                Log.d("Receiving",value.toString())
                stringResult+= String(byte,0,value)

                Log.d("Receiving",stringResult)
                if(stringResult[stringResult.length-1]=='.'){
                    break
                }

            }


            return stringResult
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            tv_result.text= result
            stringResult=""

        }
    }

}
