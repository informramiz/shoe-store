package github.informramiz.shoestore.view.onboarding.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import github.informramiz.shoestore.R
import github.informramiz.shoestore.databinding.LoginFragmentBinding
import github.informramiz.shoestore.model.preferences.ShoePreferences

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() =
            LoginFragment()
    }

    private val viewModel: LoginViewModel by activityViewModels()
    private lateinit var viewBinding: LoginFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(layoutInflater, R.layout.login_fragment, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getAuthenticationState().observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                AuthenticationState.AUTHENTICATED -> {
                    if (ShoePreferences.App.shared.isWelcomeScreenShown) {
                        findNavController().popBackStack()
                    } else {
                        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                    }
                }
                AuthenticationState.AUTHENTICATION_REFUSED -> requireActivity().finish()
                else -> {
                    viewBinding.lifecycleOwner = this
                    viewBinding.loginViewModel = viewModel
                }
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            viewModel.authenticationRefused()
        }
    }
}
