package com.example.game_list.data.datasources.profiles

import com.example.game_list.data.services.ApiKeyInterceptor
import com.example.game_list.data.services.RawgService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataSourceModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor("0ee923f2ae8741a8b1c6a32605694458"))
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RawgService::class.java)
    }
}