package com.tunahanozatac.kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lightweight : Oldukça hafif yapı ve verimlidir.
        //Scope
        //GlobalScope : Tüm App üstünde : genelde çok fazla kullanılmaz yapılacak yerde kullanılır.
        // runBlocking : Scope oluşturuyor fakat bloklayarak oluşturuyor. Çok fazla çıkmaz.
        //CoroutineScope : ierisindeki tüm coroutinler bitene kadar çalışmaya devam ediyor.


        GlobalScope.launch {
            repeat(100000) {
                launch {
                    println("Android")
                }
            }
        }

        println("runBlocking Start")
        runBlocking {
            launch {
                delay(5000)
                println("runBlocking")
            }
        }
        println("runBlocking end")

        println("globalScope start")
        GlobalScope.launch {
            delay(5000)
            println("globalScope ")
        }
        println("globalScope end")

        //CoroutineScope : Hnagi thread de çalıştılacagına kadar seçebiliyoruz.s

        println("CoroutineScope Start")
        CoroutineScope(Dispatchers.Default).launch {
            //Dispatchers aslında bizim Coroutine hangi thread içerisinde çalışacagı ile ilgili
            delay(5000)
            println("CoroutineScope ")
        }
        println("CoroutineScope End")
    }
}