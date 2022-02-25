package com.example.maktabquiz.data

import android.content.Context
import android.os.Handler
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException
import java.util.concurrent.*

object NetworkManger {
    private val executor = Executors.newSingleThreadExecutor()
    val client = OkHttpClient
        .Builder()
        .callTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(createLoggingInterceptor())
        .build()


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

    inline fun enqueue(
        request: Request.Builder.() -> Unit,
        crossinline onFailure: (Call, IOException) -> Unit,
        crossinline onResponse: (call: Call, response: Response) -> Unit
    ) {
        client.newCall(Request.Builder().apply(request).build())
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    onFailure(call, e)
                }

                override fun onResponse(call: Call, response: Response) {
                    onResponse(call, response)
                }
            })
    }

    fun createLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY

        }
    }

    const val BASE_URL = "https://api.github.com/"
    const val URL = "https://picsum.photos/seed/orange/200/300"

}