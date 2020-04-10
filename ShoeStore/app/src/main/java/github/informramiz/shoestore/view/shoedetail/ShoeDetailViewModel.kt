package github.informramiz.shoestore.view.shoedetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import github.informramiz.shoestore.R
import github.informramiz.shoestore.ShoeApplication
import github.informramiz.shoestore.model.entities.Shoe

class ShoeDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val _addShoeEvent = MutableLiveData<AddShoeEvent>()
    val addShoeEvent: LiveData<AddShoeEvent>
        get() = _addShoeEvent

    val shoe = MutableLiveData<Shoe>()
//    val shoe: LiveData<Shoe>
//        get() = _shoe

    fun setShoe(shoe: Shoe?) {
        this.shoe.value = shoe ?: Shoe("")
    }

    fun onSave(shoe: Shoe) {
        if (shoe.name.isBlank() || shoe.company.isBlank() || shoe.size == 0.0) {
            _addShoeEvent.value = AddShoeEvent.AddShoeError(
                getApplication<ShoeApplication>().applicationContext
                    .getString(R.string.shoe_detail_fragment_add_shoe_error)
            )
        } else {
            _addShoeEvent.value = AddShoeEvent.AddNewShoe(shoe)
        }
    }

    fun onCancel() {
        _addShoeEvent.value = AddShoeEvent.AddShoeCanceled
    }

    fun markAddShoeEventComplete() {
        _addShoeEvent.value = AddShoeEvent.AddShoeCompleted
    }
}
