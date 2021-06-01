package com.tunahanozatac.kotlincoroutine

import kotlinx.coroutines.*

fun main() {

    runBlocking {
        launch {
            delay(5000)
            println("Run bloking")

        }

        coroutineScope {
            launch {
                delay(3000)
                println("coroutineScope")
            }
        }
    }

    //Dispatchers : Farklı thread lerde çalıştırmamaıza olana saglıyor.
    //Dispatchers.Default -> CPU Intensive : Görsel işleme, çok uzun bir diziyi dizme
    //Dispatchers.IO : Input / Output / Networkikng : Internetten veri çekme
    //Dispatchers.Main : UI : Kullanıcının görecegi işlemleri yapmamız gerekiyor.
    //birbirleri ile ilişkili birinde yapılan işlem digerinde gösterile biliyor.
    // Dispatchers.Unconfined : Inherited-Dispatchers : Nerede oluşturlduysa miras alıyor.

    runBlocking {
        launch(Dispatchers.Main) {
            println("Main Thread : ${Thread.currentThread().name}")
        }
        launch(Dispatchers.IO) {
            println("IO Thread : ${Thread.currentThread().name}")
        }
        launch (Dispatchers.Default) {
            println("Default Thread : ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) {
            println("Unconfined Thread : ${Thread.currentThread().name}")
        }
    }
}