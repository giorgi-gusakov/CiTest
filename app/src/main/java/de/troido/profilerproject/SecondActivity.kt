package de.troido.profilerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

const val EXTRA_KEY ="extra_key"
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val parcelableClass = intent.getParcelableExtra<ParcelableClass>(EXTRA_KEY);
        parcelableClass!!.data.joinToString(";").let {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        }
    }
}