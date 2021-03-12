package de.troido.profilerproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ReferenceHolder.reference = Intermediate(
            Intermediate(
                (Intermediate(
                    Intermediate(
                        Intermediate(
                            Intermediate(
                                Intermediate(
                                    Intermediate(
                                        Intermediate(
                                            Intermediate(
                                                Intermediate(
                                                    Intermediate(this)
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                ))
            )
        )
    }
}