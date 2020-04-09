package github.informramiz.shoestore.view.onboarding.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import github.informramiz.shoestore.model.preferences.ShoePreferences
import timber.log.Timber

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val authenticationState = MutableLiveData<AuthenticationState>()

    init {
        authenticationState.value = ShoePreferences.User.shared.isUserLoggedIn.toAuthenticationState()
    }

    fun getAuthenticationState(): LiveData<AuthenticationState> {
        return authenticationState
    }

    fun userAuthenticationStateUpdated() {
        authenticationState.value = ShoePreferences.User.shared.isUserLoggedIn.toAuthenticationState()
    }

    fun authenticateUser(userName: String, password: String) {
        ShoePreferences.User.shared.isUserLoggedIn = true
        userAuthenticationStateUpdated()
    }

    fun dummy() {
        Timber.d("Dummy called")
    }

    private fun Boolean.toAuthenticationState(): AuthenticationState {
        return if (this) AuthenticationState.AUTHENTICATED else AuthenticationState.UNAUTHENTICATED
    }
}
