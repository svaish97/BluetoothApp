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
import java.lang.Exception
import java.text.DecimalFormat
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
    var countInChar:Char = '\u0000'
    var test:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deviceAddress=intent.getStringExtra("DeviceAddress")

        madapter= BluetoothAdapter.getDefaultAdapter()

        if(madapter.isEnabled) {
            try {
                mdevice = madapter.getRemoteDevice(deviceAddress)
                bluetoothSocket = mdevice.createRfcommSocketToServiceRecord(uuid)
                val bluetoothServ = BluetoothServ()
                bluetoothServ.execute()
                Thread.sleep(5000)
            }
           catch (e:Exception){
               Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
           }

        }




        one.setOnClickListener {
            stringtoSend="1"
            if(boolean){
            outputStream.write(stringtoSend.toByteArray())
            receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }


        }
        two.setOnClickListener {
            if(boolean){
            stringtoSend="2"
            outputStream.write(stringtoSend.toByteArray())
            receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }



        }
        three.setOnClickListener {
            if (boolean) {
                stringtoSend = "3"
                outputStream.write(stringtoSend.toByteArray())
                receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        four.setOnClickListener {
            if(boolean) {
                stringtoSend = "4"
                outputStream.write(stringtoSend.toByteArray())
                receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }

        }
        five.setOnClickListener {
            if(boolean) {
                stringtoSend = "5"
                outputStream.write(stringtoSend.toByteArray())
//                receive()
                tv_1.text=""
                tv_2.text=""
                tv_3.text=""
                tv_4.text=""
                result_1.text=""
                result_2.text=""
                result_3.text=""
                result_4.text=""
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        six.setOnClickListener {
            if(boolean) {
                stringtoSend = "6"
                outputStream.write(stringtoSend.toByteArray())
                receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        seven.setOnClickListener {
            if(boolean) {
                stringtoSend = "7"
                outputStream.write(stringtoSend.toByteArray())
//                receive()
                tv_1.text=""
                tv_2.text=""
                tv_3.text=""
                tv_4.text=""
                result_1.text=""
                result_2.text=""
                result_3.text=""
                result_4.text=""
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        eight.setOnClickListener {
            if(boolean) {
                stringtoSend = "8"
                outputStream.write(stringtoSend.toByteArray())
//                receive()
                tv_1.text=""
                tv_2.text=""
                tv_3.text=""
                tv_4.text=""
                result_1.text=""
                result_2.text=""
                result_3.text=""
                result_4.text=""
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        nine.setOnClickListener {
            if(boolean) {
                stringtoSend = "9"
                outputStream.write(stringtoSend.toByteArray())
                receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        zero.setOnClickListener {
            if(boolean) {
                stringtoSend = "0"
                outputStream.write(stringtoSend.toByteArray())
                receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        A.setOnClickListener {
            if(boolean) {
                stringtoSend = "A"
                outputStream.write(stringtoSend.toByteArray())
                receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        B.setOnClickListener {
            if(boolean) {
                stringtoSend = "B"
                outputStream.write(stringtoSend.toByteArray())
                receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        C.setOnClickListener {
            if(boolean) {
                stringtoSend = "C"
                outputStream.write(stringtoSend.toByteArray())
                receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        D.setOnClickListener {
            if(boolean) {
                stringtoSend = "D"
                outputStream.write(stringtoSend.toByteArray())
                receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }

        }
        star.setOnClickListener {
            if (boolean) {
                stringtoSend = "*"
                outputStream.write(stringtoSend.toByteArray())
                receive()
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
        }
        hash.setOnClickListener {
            if(boolean) {
                stringtoSend = "#"
                outputStream.write(stringtoSend.toByteArray())
//                receive()
                tv_1.text=""
                tv_2.text=""
                tv_3.text=""
                tv_4.text=""
                result_1.text=""
                result_2.text=""
                result_3.text=""
                result_4.text=""
            }
            else{
                Toast.makeText(baseContext,"Device Not Available",Toast.LENGTH_SHORT).show()
            }
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
            try {
                bluetoothSocket.connect()
            }
            catch (e:Exception){
                bluetoothSocket.close()
            }

            return null
        }

        override fun onPostExecute(result: Void?) {
            if(bluetoothSocket.isConnected){
                outputStream=bluetoothSocket.outputStream
                inputStream=bluetoothSocket.inputStream
                boolean=true
            }
            else{
                Toast.makeText(baseContext,"Device not in Range",Toast.LENGTH_SHORT).show()
            }


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
                    runOnUiThread {
                        val value=stringResult.substring(9,12)
                        countInChar=stringResult[12]
                        val sen1=stringResult[13]
                        val flag=stringResult[14]
                        val oil=stringResult.substring(1,8)

                        if(stringResult[0]=='1' && Character.getNumericValue(countInChar)%3==1){
                            tv_1.text="CO  :+"
                            tv_2.text="HC  :+"
                            tv_3.text="CO2 :+"
                            tv_4.text="O2  :+"
                            result_1.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.8).toString()+"  "+test
                            result_2.text=DecimalFormat("##.00").format(Integer.parseInt(value)*2.0).toString()+"  ppm"
                            result_3.text=DecimalFormat("##.00").format(Integer.parseInt(value)*1.8).toString()
                            result_4.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.6).toString()+" "+oil
                        }
                        if(stringResult[0]=='1' && Character.getNumericValue(countInChar)%3==2){
                            test=""
                            tv_1.text="CO  :+"
                            tv_2.text="NOX :+"
                            tv_3.text="SOX :+"
                            tv_4.text="O2  :+"
                            result_1.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.8).toString()
                            result_2.text=DecimalFormat("##.00").format(Integer.parseInt(value)*2.0).toString()+"  ppm"
                            result_3.text=DecimalFormat("##.00").format(Integer.parseInt(value)*1.8).toString()
                            result_4.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.6).toString()+" "+oil
                        }
                        if(stringResult[0]=='1' && Character.getNumericValue(countInChar)%3==0){
                            test=""
                            tv_1.text="Oil tp :+"
                            tv_2.text="A.F.R. :+"
                            tv_3.text="Lambda :+"
                            tv_4.text="CO :+"
                            result_1.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.6).toString()
                            result_2.text=DecimalFormat("##.00").format(Integer.parseInt(value)*2.0).toString()+"  ppm"
                            result_3.text=DecimalFormat("##.00").format(Integer.parseInt(value)*1.8).toString()
                            result_4.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.8).toString()+" "+oil
                        }

                        if(stringResult[0]=='2'){
                            test=""
                            tv_1.text="rpm  "
                            tv_2.text="pres "
                            tv_3.text="flow "
                            tv_4.text="temp "
                            result_1.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.8).toString()
                            result_2.text=DecimalFormat("##.00").format(Integer.parseInt(value)*1.0).toString()
                            result_3.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.7).toString()
                            result_4.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.6).toString()
                        }
                        if(stringResult[0]=='3'){
                            test=""
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text="Serial No"
                            result_2.text=""
                            result_3.text="[1000479]"
                            result_4.text=""
                        }
                        if(stringResult[0]=='4'){
                            test=""
                            tv_1.text="DATE"
                            tv_2.text=""
                            tv_3.text="TIME"
                            tv_4.text=""
                            result_1.text=""
                            result_2.text=""
                            result_3.text=""
                            result_4.text=""
                        }
                        if(stringResult[0]=='A'){
                            test="TEST"
                            tv_1.text="CO  :+"
                            tv_2.text="HC  :+"
                            tv_3.text="CO2 :+"
                            tv_4.text="O2  :+"
                            result_1.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.8).toString()+" "+test
                            result_2.text=DecimalFormat("##.00").format(Integer.parseInt(value)*2.0).toString()
                            result_3.text=DecimalFormat("##.00").format(Integer.parseInt(value)*1.8).toString()
                            result_4.text=DecimalFormat("##.00").format(Integer.parseInt(value)*0.6).toString()+" "+oil
                        }
                        if(stringResult[0]=='B'){
                            tv_1.text="MAKE  :"
                            tv_2.text="MODEL :"
                            tv_3.text="Version :"
                            tv_4.text="Serial No.:"
                            result_1.text="VOLCANO"
                            result_2.text="DP-204P"
                            result_3.text="4 FEB 2019"
                            result_4.text="12P125"
                        }
                        if(stringResult[0]=='*'){
                            tv_1.text="Model No  "
                            tv_2.text="Version "
                            tv_3.text="Serial No. :"
                            tv_4.text="Ful=PET,"
                            result_1.text="DP-204P"
                            result_2.text="04 FEB 2019"
                            result_3.text="12P125"
                            result_4.text="CNG,LPG"
                        }
                        if(stringResult[0]=='D' && sen1=='0' && flag=='0'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="PRINT"
                            result_3.text=""
                            result_4.text=""
                        }
                        if(stringResult[0]=='D' && sen1=='1' && flag=='0'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="ENTER PAPER"
                            result_3.text=""
                            result_4.text=""
                        }
                        if(stringResult[0]=='9'){
                            tv_1.text="0-PETROL"
                            tv_2.text="1-PET+CNG"
                            tv_3.text="2-PET+LPG"
                            tv_4.text="SELECT"
                            result_1.text="3-C.N.G"
                            result_2.text="4-L.P.G"
                            result_3.text=""
                            result_4.text="FUEL"
                        }
                        if(stringResult[0]=='C'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="Zero Setting"
                            result_3.text=""
                            result_4.text="Wait"
                        }



                        if(stringResult[0]=='F'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="Zero Setting"
                            result_3.text=""
                            result_4.text="Done"
                        }
                        if(stringResult[0]=='G'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="HC Residue Check"
                            result_3.text=""
                            result_4.text=""
                        }
                        if(stringResult[0]=='H'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="HC Residue OK"
                            result_3.text=""
                            result_4.text=""
                        }

                        if(stringResult[0]=='6'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="Pump Off"
                            result_3.text="Measurement Off"
                            result_4.text=""
                        }

                        if(stringResult[0]=='I'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="Press key <1>"
                            result_3.text=""
                            result_4.text=""
                        }

                        if(stringResult[0]=='J'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="Zero Setting"
                            result_3.text=""
                            result_4.text="Wait"
                        }

                        if(stringResult[0]=='K'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="Zero Setting"
                            result_3.text=""
                            result_4.text="Done"
                        }

                        if(stringResult[0]=='L'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="HC Residue Check"
                            result_3.text=""
                            result_4.text=""
                        }
                        if(stringResult[0]=='M'){
                            tv_1.text=""
                            tv_2.text=""
                            tv_3.text=""
                            tv_4.text=""
                            result_1.text=""
                            result_2.text="HC Residue OK"
                            result_3.text=""
                            result_4.text=""
                        }










//                        tv_3.text=(Character.getNumericValue(countInChar)%3).toString()
//                        tv_4.text=oil
//                        result_4.text=value
////                       tv_result.text= stringResult
                        stringResult=""
                    }
                }

            }


            return stringResult
        }

//        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
//
//
//        }
    }



}
