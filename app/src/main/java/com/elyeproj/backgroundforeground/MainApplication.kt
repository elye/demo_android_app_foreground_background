package com.elyeproj.backgroundforeground

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

class MainApplication: Application() {
    private val lifecycleListener: MainLifecycleListener by lazy {
        MainLifecycleListener()
    }

    override fun onCreate() {
        super.onCreate()
        setupLifecycleListener()
    }

    private fun setupLifecycleListener() {
        ProcessLifecycleOwner.get().lifecycle.addObserver(lifecycleListener)
    }
}
