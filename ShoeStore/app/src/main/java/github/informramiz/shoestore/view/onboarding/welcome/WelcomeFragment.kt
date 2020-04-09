package github.informramiz.shoestore.view.onboarding.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import github.informramiz.shoestore.R
import github.informramiz.shoestore.databinding.WelcomeFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<WelcomeFragmentBinding>(inflater,
            R.layout.welcome_fragment, container, false)
        return binding.root
    }
}
