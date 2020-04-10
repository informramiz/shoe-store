package github.informramiz.shoestore.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ramiz Raja on 10/04/2020
 */
@Parcelize
data class Shoe(var name: String, var size: Double = 1.0, var company: String = "",
                var description: String = "",
                val images: List<String> = mutableListOf()): Parcelable