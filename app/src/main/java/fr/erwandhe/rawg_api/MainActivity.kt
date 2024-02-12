package fr.erwandhe.rawg_api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.game_list.GameFragment
import fr.erwandhe.rawg_api.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(fr.erwandhe.rawg_api.R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(appModule)
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, GameFragment())
            .commit()
    }
}