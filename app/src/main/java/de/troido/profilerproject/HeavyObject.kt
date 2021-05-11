package de.troido.profilerproject

import kotlin.random.Random

class HeavyObject{
    val data:ByteArray = ByteArray(10_000_000)
    init {
        Random.nextBytes(data)
    }
}