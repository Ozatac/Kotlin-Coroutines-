package com.tunahanozatac.kotlincoroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    //Job
    runBlocking {
        val myjob = launch {
            delay(2000)
            println("Job")
            val secondmyjob = launch {
                println("Job2 ")
            }
        }

        myjob.invokeOnCompletion {
            println("my Job end")
        }
        myjob.cancel()
    }
}