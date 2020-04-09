package github.informramiz.shoestore.view.shoelist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import github.informramiz.shoestore.R
import github.informramiz.shoestore.view.home.MainViewModel
import github.informramiz.shoestore.databinding.ShoeListFragmentBinding
import github.informramiz.shoestore.view.onboarding.login.AuthenticationState
import github.informramiz.shoestore.view.onboarding.login.LoginViewModel

class ShoeListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()
    private val loginViewModel: LoginViewModel by activityViewModels()
    private lateinit var viewBinding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginViewModel.getAuthenticationState().observe(viewLifecycleOwner, Observer { state ->
            when(state) {
                AuthenticationState.AUTHENTICATED -> showWelcomeMessage()
                else -> findNavController().navigate(R.id.onboarding_nav_graph)
            }
        })
    }

    private fun showWelcomeMessage() {
        Toast.makeText(context, getString(R.string.shoe_list_fragment_welcome_msg), Toast.LENGTH_SHORT).show()
    }
}
