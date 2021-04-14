package org.sopt.databindingexercise

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val BASE_URL = "http://api.github.com"

    val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val githubApi = retrofit.create(GithubApi::class.java)
}