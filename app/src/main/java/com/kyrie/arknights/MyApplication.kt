package com.kyrie.arknights

import android.app.Application
import com.kyrie.arknights.log.KLogger
import com.kyrie.arknights.manager.DbManager

class MyApplication : Application() {
    private val TAG = "MyApplication"

    override fun onCreate() {
        super.onCreate()
        KLogger.init(this)
        initDb(this)
    }

    private fun initDb(application: Application) {
        DbManager.init(application)
    }
}