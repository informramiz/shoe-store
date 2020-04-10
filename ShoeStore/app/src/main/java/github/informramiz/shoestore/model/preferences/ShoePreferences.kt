package github.informramiz.shoestore.model.preferences

import android.content.Context

/**
 * Created by Ramiz Raja on 08/04/2020
 */
object ShoePreferences {
    private lateinit var context: Context
    object App {
        val shared = AppPreferences(context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE))
    }

    object User {
        val shared = UserPreferences(context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE))
    }

    fun init(context: Context) {
        ShoePreferences.context = context
    }

    fun clear() {
        ShoePreferences.App.shared.clear()
        ShoePreferences.User.shared.clear()
    }
}