package de.troido.profilerproject

import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.troido.bless.Bless
import kotlinx.android.parcel.Parcelize

@kotlinx.parcelize.Parcelize
class ParcelableClass private constructor(val data:Set<String>):Parcelable{
    companion object {
        fun build()=ParcelableClass(setOf("one","two","three"));
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Bless.initialize(this)
        findViewById<Button>(R.id.button).setOnClickListener {
            invokeCommand()
        }
    }

    private fun invokeCommand() {
        println("print something")
        val parcelableClass = ParcelableClass.build()
        val intent = Intent(this,SecondActivity::class.java).also {
            it.putExtra(EXTRA_KEY,parcelableClass)
        }
        startActivity(intent)
//        BlessScanActivity.startForResult(this, 1)
//        val filter = ScanFilter.empty()
//        val settings = ScanSettings.default()
//        val callback = object : com.troido.bless.scan.ScanCallback<com.troido.bless.scan.ScanResult> {
//            override fun onScanFailed(errorCode: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onScanResult(result: com.troido.bless.scan.ScanResult) {
//                TODO("Not yet implemented")
//            }
//        }
//        Bless.bleScanner.startScan(filter, settings, callback)
//        val firstIntent = Intent(this,MyDelegate::class.java)
//        val secondIntent = Intent(this,MyDelegate::class.java)
//        val intentWithData = Intent(this,MyDelegate::class.java).apply {
//            data = Uri.parse("https://developer.android.com/reference/android/app/PendingIntent")
//        }
//
//        Log.d("MainActivity","first intent equals to second: ${firstIntent.filterEquals(secondIntent)}")1 Std. 1 Min.
//        // Initializes Bluetooth adapter.
//        val bluetoothManager = getSystemService(BluetoothManager::class.java)
//        val bluetoothAdapter: BluetoothAdapter = bluetoothManager!!.adapter
//
//        val bluetoothLeScanner: BluetoothLeScanner? = bluetoothAdapter.bluetoothLeScanner
//        var scanning = false
//        val handler = Handler()
//
//// Stops scanning after 10 seconds.
//        val SCAN_PERIOD: Long = 10000
//        bluetoothLeScanner!!.let { scanner ->
//            if (!scanning) { // Stops scanning after a pre-defined scan period.
//                handler.postDelayed({
//                    scanning = false
//                    scanner.stopScan(leScanCallback)
//                }, SCAN_PERIOD)
//                scanning = true
//                scanner.startScan(leScanCallback)
//            } else {
//                scanning = false
//                scanner.stopScan(leScanCallback)
//            }
//        }
    }

    private val leScanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult?) {
            Log.v("TAG", "result =$result")
        }

        override fun onBatchScanResults(results: MutableList<ScanResult>?) {
            Log.v("TAG", "batch result =$results")
        }

        override fun onScanFailed(errorCode: Int) {
            Log.v("TAG", "scan failed. errorCode = $errorCode")
        }
    }
}