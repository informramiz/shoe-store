package github.informramiz.shoestore

import android.app.Application
import github.informramiz.shoestore.model.preferences.ShoePreferences

/**
 * Created by Ramiz Raja on 09/04/2020
 */
class ShoeApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ShoePreferences.init(this)
    }
}