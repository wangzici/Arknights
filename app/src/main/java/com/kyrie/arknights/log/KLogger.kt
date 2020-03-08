package com.kyrie.arknights.log

import android.app.Application
import com.kyrie.arknights.BuildConfig
import com.tencent.mars.xlog.Log
import com.tencent.mars.xlog.Xlog

/**
 * Created by Kyrie
 * Date: 2020/3/1
 *
 */
object KLogger {

    fun init(application: Application){
        System.loadLibrary("c++_shared")
        System.loadLibrary("marsxlog")
        val sdcard = application.getExternalFilesDir(null)?.absolutePath
        val cachePath = application.filesDir.absolutePath
        val logPath = "$sdcard/log"
        if (BuildConfig.DEBUG) {
            Xlog.appenderOpen(Xlog.LEVEL_DEBUG, Xlog.AppednerModeAsync, cachePath, logPath, "kyrie", 0, "");
            Xlog.setConsoleLogOpen(true);

        } else {
            Xlog.appenderOpen(Xlog.LEVEL_INFO, Xlog.AppednerModeAsync, cachePath, logPath, "kyrie", 0, "");
            Xlog.setConsoleLogOpen(false);
        }
        Log.setLogImp(Xlog())
    }

    fun destroy(){
        Log.appenderClose()
    }
}