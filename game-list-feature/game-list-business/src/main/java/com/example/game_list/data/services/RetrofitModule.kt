package com.example.game_list.data.services

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
        single {
                OkHttpClient.Builder()
                        .addInterceptor(ApiKeyInterceptor("0ee923f2ae8741a8b1c6a32605694458")) // Remplacez par votre clé API
                        .build()
        }

        single {
                Retrofit.Builder()
                        .baseUrl("https://api.rawg.io/api/games/")
                        .client(get())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
        }

        single {
                get<Retrofit>().create(RawgService::class.java)
        }
}