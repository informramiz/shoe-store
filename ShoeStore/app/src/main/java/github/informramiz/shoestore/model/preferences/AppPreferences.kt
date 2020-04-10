package github.informramiz.shoestore.model.preferences

import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * Created by Ramiz Raja on 09/04/2020
 */
class AppPreferences(private val sharedPreferences: SharedPreferences) {
    companion object Keys {
        const val IS_WELCOME_SCREEN_SHOWN = "is_welcome_screen_shown"
    }

    var isWelcomeScreenShown: Boolean
        get() = sharedPreferences.getBoolean(IS_WELCOME_SCREEN_SHOWN, false)
        set(value) {
            sharedPreferences.edit {
                putBoolean(IS_WELCOME_SCREEN_SHOWN, value)
            }
        }

    fun clear() {
        sharedPreferences.edit { clear() }
    }
}