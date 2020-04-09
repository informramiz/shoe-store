package github.informramiz.shoestore

import android.app.Application
import github.informramiz.shoestore.model.preferences.ShoePreferences
import timber.log.Timber

/**
 * Created by Ramiz Raja on 09/04/2020
 */
class ShoeApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        ShoePreferences.init(this)
    }
}