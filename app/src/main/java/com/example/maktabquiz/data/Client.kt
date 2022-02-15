package com.example.maktabquiz.data

import android.content.Context
import android.os.Handler
import okhttp3.*
import okhttp3.internal.http2.Http2Reader
import java.io.IOException
import java.util.concurrent.*

object Client {
    private val client = OkHttpClient()
    private val executor = Executors.newSingleThreadExecutor()

    fun execute(
        request: Request,
        onResponse: (response: String?) -> Unit
    ): Future<*> {
        return executor.submit {
            val response = try {
                client.newCall(request).execute().body?.string()
            } catch (ioe: IOException) {
                ioe.message
            }
            onResponse(response)
        }
    }

    fun executeWithHandler(
        context: Context,
        request: Request,
        onResponse: (response: String?) -> Unit
    ): Future<*> {
        return executor.submit {
            val response = try {
                client.newCall(request).execute().body?.string()
            } catch (ioe: IOException) {
                ioe.message
            }
            val handler = Handler(context.mainLooper)
            handler.post {
                onResponse(response)
            }
        }
    }


    fun enqueue(request: Request.Builder.() -> Unit, callback: Callback) {
        client.newCall(Request.Builder().apply(request).build()).enqueue(callback)
    }

    const val URL = "https://picsum.photos/seed/orange/200/300"

}