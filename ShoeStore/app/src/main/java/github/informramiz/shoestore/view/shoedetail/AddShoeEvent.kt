package github.informramiz.shoestore.view.shoedetail

import github.informramiz.shoestore.model.entities.Shoe

/**
 * Created by Ramiz Raja on 10/04/2020
 */
sealed class AddShoeEvent {
    object AddShoeCompleted : AddShoeEvent()
    class AddNewShoe(val shoe: Shoe): AddShoeEvent()
    class AddShoeError(val error: String): AddShoeEvent()
    object AddShoeCanceled : AddShoeEvent()
}

val <T> T.exhaustive: T
    get() = this