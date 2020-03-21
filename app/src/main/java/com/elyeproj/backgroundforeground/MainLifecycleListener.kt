package com.elyeproj.backgroundforeground

import android.os.Handler
import android.os.HandlerThread
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainLifecycleListener: LifecycleObserver {
    private val handlerThread = HandlerThread("HandlerThread")
    companion object {
        const val ONE_SECOND = 1000L
    }

    init {
        handlerThread.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground() {
        println("Track: Foreground ${Thread.currentThread()}")
        Handler(handlerThread.looper).postDelayed({
            println("Track: Enter Foreground handler ${Thread.currentThread()}")
            for (index in 1..10) {
                Thread.sleep(ONE_SECOND)
                println("Elisha: After Foreground handler $index")
            }
        }, ONE_SECOND)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMoveToBackground() {
        println("Track: Background ${Thread.currentThread()}")
        Handler(handlerThread.looper).postDelayed({
            println("Track: Enter Background handler ${Thread.currentThread()}")
            for (index in 1..10) {
                Thread.sleep(ONE_SECOND)
                println("Elisha: After Background handler $index")
            }
        }, ONE_SECOND)
    }
}