package github.informramiz.shoestore.view.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Ramiz Raja on 10/04/2020
 */
class ShoeListViewModel: ViewModel() {
    private val _addShoeEvent = MutableLiveData<Boolean>()
    val addShoeEvent: LiveData<Boolean>
        get() = _addShoeEvent

    fun addShoe() {
        _addShoeEvent.value = true
    }

    fun markAddShoeEventComplete() {
        _addShoeEvent.value = false
    }
}