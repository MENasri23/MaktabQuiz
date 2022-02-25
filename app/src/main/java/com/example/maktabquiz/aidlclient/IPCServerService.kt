package com.example.maktabquiz.aidlclient

import com.example.maktabquiz.screen.enqueue.MyAIDL
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Process

class IPCServerService : Service() {

    companion object {
        var connectionCount: Int = 0
        val NOT_SENT = "Not sent!"
    }

    private val binder = object : MyAIDL.Stub() {

        override fun getPid(): Int = Process.myPid()

        override fun getConnectionCount(): Int = connectionCount

        override fun setDisplayedValue(packageName: String?, pid: Int, data: String?) {
            val clientData =
                if (data == null || data.isEmpty()) NOT_SENT
                else data

            RecentClient.client = Client(
                packageName ?: NOT_SENT,
                pid.toString(),
                clientData,
                "AIDL"
            )
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        connectionCount++
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        RecentClient.client = null
        return super.onUnbind(intent)
    }

}