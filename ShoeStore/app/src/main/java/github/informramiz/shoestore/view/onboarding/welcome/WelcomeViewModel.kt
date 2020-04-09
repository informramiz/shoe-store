package github.informramiz.shoestore.view.onboarding.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import github.informramiz.shoestore.model.preferences.ShoePreferences

/**
 * Created by Ramiz Raja on 10/04/2020
 */
class WelcomeViewModel: ViewModel() {
    private val _eventWelcomeDone = MutableLiveData<Boolean>()
    val eventWelcomeDone: LiveData<Boolean>
        get() = _eventWelcomeDone

    init {
        ShoePreferences.App.shared.isWelcomeScreenShown = true
    }

    fun onNext() {
        _eventWelcomeDone.value = true
    }

    fun eventWelcomeDoneComplete() {
        //reset the data because it was an event and it has finished
        _eventWelcomeDone.value = false
    }
}