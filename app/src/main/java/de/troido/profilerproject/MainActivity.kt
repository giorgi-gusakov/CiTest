package de.troido.profilerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDelegate = MyDelegate()
        val intermediate = Intermediate()
        myDelegate.reference = intermediate
        intermediate.reference=myDelegate
        ReferenceHolder.reference = myDelegate
    }
}