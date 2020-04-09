package github.informramiz.shoestore.view.onboarding.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import github.informramiz.shoestore.databinding.LoginFragmentBinding

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
        viewBinding = LoginFragmentBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getAuthenticationState().observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                AuthenticationState.AUTHENTICATED -> {
                    findNavController().popBackStack()
                }
                else -> {
                    viewBinding.lifecycleOwner = this
                    viewBinding.loginViewModel = viewModel
                }
            }
        })
    }
}
