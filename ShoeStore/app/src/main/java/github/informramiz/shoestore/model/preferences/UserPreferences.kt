package github.informramiz.shoestore.model.preferences

import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * Created by Ramiz Raja on 09/04/2020
 */
class UserPreferences(private val sharedPreferences: SharedPreferences) {
    companion object Keys {
        const val IS_USER_LOGGED_IN = "isUserLoggedIn"
    }

    var isUserLoggedIn: Boolean
        get() = sharedPreferences.getBoolean(IS_USER_LOGGED_IN, false)
        set(value) {
            sharedPreferences.edit {
                putBoolean(IS_USER_LOGGED_IN, value)
            }
        }

    fun clear() {
        sharedPreferences.edit { clear() }
    }
}