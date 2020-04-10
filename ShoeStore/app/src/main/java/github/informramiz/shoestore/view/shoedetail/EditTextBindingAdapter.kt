package github.informramiz.shoestore.view.shoedetail

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter

/**
 * Created by Ramiz Raja on 10/04/2020
 */
object EditTextBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:text")
    fun setText(editText: EditText, float: Double) {
        val text = if (float > 0.0) float.toString() else ""
        editText.setText(text)
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "android:text")
    fun getDouble(editText: EditText?): Double {
        val text = editText?.text?.toString() ?: ""
        return if (text.isBlank()) 0.0 else text.toDouble()
    }
}