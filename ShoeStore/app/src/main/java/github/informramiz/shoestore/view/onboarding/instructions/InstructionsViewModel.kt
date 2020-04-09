package github.informramiz.shoestore.view.onboarding.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Ramiz Raja on 10/04/2020
 */
class InstructionsViewModel: ViewModel() {
    private val _eventInstructionsDone = MutableLiveData<Boolean>()
    val eventInstructionsDone: LiveData<Boolean>
        get() = _eventInstructionsDone

    fun onNext() {
        _eventInstructionsDone.value = true
    }

    fun eventInstructionsDoneComplete() {
        //reset the data because it was an event and it has finished
        _eventInstructionsDone.value = false
    }
}