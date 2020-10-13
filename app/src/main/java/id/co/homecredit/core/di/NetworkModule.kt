/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 12:53 PM
 *
 */

package id.co.homecredit.core.di

import dagger.Module
import dagger.Provides
import id.co.homecredit.core.data.source.remote.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .build()

    @Provides
    fun provideApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://private-anon-ede4fccbd0-hcidtest.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}