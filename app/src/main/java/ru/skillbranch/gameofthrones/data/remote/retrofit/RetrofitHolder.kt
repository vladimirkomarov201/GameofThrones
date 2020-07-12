package ru.skillbranch.gameofthrones.data.remote.retrofit

import android.content.Context
import android.os.Build
import android.provider.Settings
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.skillbranch.gameofthrones.AppConfig
import java.util.concurrent.TimeUnit


class RetrofitHolder(
    private val context: Context
) {

    fun getApi(): ApiService {

        val httpClient = OkHttpClient.Builder().apply {

            addInterceptor(getLogger())

            networkInterceptors().add(userAgentInterceptor)
            connectTimeout(AppConfig.RETROFIT_CONNECTION_TIMEOUT_SEC, TimeUnit.SECONDS)
            readTimeout(AppConfig.RETROFIT_CONNECTION_TIMEOUT_SEC, TimeUnit.SECONDS)
            writeTimeout(AppConfig.RETROFIT_CONNECTION_TIMEOUT_SEC, TimeUnit.SECONDS)
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    private fun getLogger(): HttpLoggingInterceptor{
        val result = HttpLoggingInterceptor()
        result.level = HttpLoggingInterceptor.Level.BODY
        return result
    }

    private val userAgentInterceptor = Interceptor { chain ->
        val originalRequest: Request = chain.request()
        val userAgent = "Android ${Build.VERSION.RELEASE} " +
                "${Build.MANUFACTURER} " +
                "${Build.MODEL} " +
                Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        val requestWithUserAgent: Request = originalRequest.newBuilder()
            .header("User-Agent", userAgent)
            .build()
        chain.proceed(requestWithUserAgent)
    }

}
