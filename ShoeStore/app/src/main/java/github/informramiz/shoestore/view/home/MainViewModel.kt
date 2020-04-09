package github.informramiz.shoestore.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import github.informramiz.shoestore.model.entities.Shoe
import github.informramiz.shoestore.model.preferences.ShoePreferences

class MainViewModel : ViewModel() {
    private val shoeListLiveData = MutableLiveData<List<Shoe>>()
    private val shoeList: MutableList<Shoe> = mutableListOf()
    private val authenticationState = MutableLiveData<AuthenticationState>()

    init {
        shoeListLiveData.value = shoeList
        authenticationState.value = ShoePreferences.User.shared.isUserLoggedIn.toAuthenticationState()
    }

    fun getAuthenticationState(): LiveData<AuthenticationState> {
        return authenticationState
    }

    fun userAuthenticationStateUpdated() {
        authenticationState.value = ShoePreferences.User.shared.isUserLoggedIn.toAuthenticationState()
    }

    fun getShoeList(): LiveData<List<Shoe>> {
        return shoeListLiveData
    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
        shoeListLiveData.value = shoeList
    }

    private fun Boolean.toAuthenticationState(): AuthenticationState {
        return if (this) AuthenticationState.AUTHENTICATED else AuthenticationState.UNAUTHENTICATED
    }
}
