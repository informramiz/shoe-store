package github.informramiz.shoestore.view.onboarding.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import github.informramiz.shoestore.model.preferences.ShoePreferences
import timber.log.Timber

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val _eventUserAuthenticated = MutableLiveData<Boolean>()
    val eventUserAuthenticated: LiveData<Boolean>
        get() = _eventUserAuthenticated

    fun authenticateUser(userName: String, password: String) {
        _eventUserAuthenticated.value = true
//        ShoePreferences.User.shared.isUserLoggedIn = true
//        ShoePreferences.App.shared.isWelcomeScreenShown = true
    }

    fun dummy() {
        Timber.d("Dummy called")
    }

    fun userAuthenticationComplete() {
        _eventUserAuthenticated.value = false
    }
}
