package github.informramiz.shoestore.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import github.informramiz.shoestore.model.entities.Shoe

class MainViewModel : ViewModel() {
    private val shoeListLiveData = MutableLiveData<List<Shoe>>()
    private val shoeList: MutableList<Shoe> = mutableListOf()
    init {
        shoeListLiveData.value = shoeList
    }

    fun getShoeList(): LiveData<List<Shoe>> {
        return shoeListLiveData
    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
        shoeListLiveData.value = shoeList
    }
}
