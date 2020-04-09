package github.informramiz.shoestore.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import github.informramiz.shoestore.R
import github.informramiz.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {

    companion object {
        fun newInstance() = InstructionsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = InstructionsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}
