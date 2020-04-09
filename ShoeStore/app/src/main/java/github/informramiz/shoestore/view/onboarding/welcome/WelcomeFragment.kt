package github.informramiz.shoestore.view.onboarding.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import github.informramiz.shoestore.R
import github.informramiz.shoestore.databinding.WelcomeFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    private val viewModel: WelcomeViewModel by viewModels()
    private lateinit var viewBinding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = DataBindingUtil.inflate(inflater,
            R.layout.welcome_fragment, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.lifecycleOwner = this
        viewBinding.welcomeViewModel = viewModel

        viewModel.eventWelcomeDone.observe(viewLifecycleOwner, Observer { isDone ->
            if (isDone) {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
                viewModel.eventWelcomeDoneComplete()
            }
        })
    }
}
