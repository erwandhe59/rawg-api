package fr.erwandhe.rawg_api

import android.app.Activity
import android.os.Bundle
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import fr.erwandhe.rawg_api.koin.appModule

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainActivity)
            // Load modules
            modules(appModule)
        }

    }
}