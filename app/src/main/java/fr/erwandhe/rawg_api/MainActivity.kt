package fr.erwandhe.rawg_api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.erwandhe.rawg_api.koin.appModule
import fr.erwandhe.rawg_api.ui.GameListFragment
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(appModule)
        }

        // Ajoutez le fragment à l'activité
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, GameListFragment())
            .commit()
    }
}
