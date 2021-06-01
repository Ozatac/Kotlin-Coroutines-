package com.tunahanozatac.kotlincoroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    //suspend fonksiyonlar : içerisinde coroutine çalıştırıla bilen fonksiyonlardır.

    /*GlobalScope.launch {
        myFunction()
    }*/

    runBlocking {
        delay(5000)
        println("runBlocking")
        myFunction()
    }
}

suspend fun myFunction() {
    coroutineScope {
        delay(5000)
        println("suspend funcktion")
    }
}