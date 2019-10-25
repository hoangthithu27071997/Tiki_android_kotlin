package com.example.tiki.extension

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class AppExecutors {
    companion object {
        val sInstance by lazy { AppExecutors() }

        fun onUI(function: () -> Unit) {
            sInstance.mMainThread.execute(function)
        }
    }

    private val mMainThread = MainThreadExecutor()

}

class MainThreadExecutor : Executor {
    private val mHandler = Handler(Looper.getMainLooper())

    override fun execute(runnable: Runnable) {
        mHandler.post(runnable)
    }
}
