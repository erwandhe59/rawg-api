package com.example.game_list.data.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.dsl.module
import org.koin.core.qualifier.named

val networkModule = module {
        single<OkHttpClient> {
                OkHttpClient.Builder()
                        .addInterceptor(ApiKeyInterceptor("0ee923f2ae8741a8b1c6a32605694458")) // Replace with your actual API key
                        .build()
        }

        single<Retrofit> {
                Retrofit.Builder()
                        .baseUrl("https://api.rawg.io/api/")
                        .client(get())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
        }

        single(named("RawgService")) {
                get<Retrofit>().create(RawgService::class.java)
        }
}
