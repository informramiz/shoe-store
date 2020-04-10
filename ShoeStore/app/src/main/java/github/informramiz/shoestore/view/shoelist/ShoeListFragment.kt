package github.informramiz.shoestore.view.shoelist


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import github.informramiz.shoestore.R
import github.informramiz.shoestore.view.home.MainViewModel
import github.informramiz.shoestore.databinding.ShoeListFragmentBinding
import github.informramiz.shoestore.databinding.ShoeListItemLayoutBinding
import github.informramiz.shoestore.model.entities.Shoe
import github.informramiz.shoestore.view.onboarding.login.AuthenticationState
import github.informramiz.shoestore.view.onboarding.login.LoginViewModel

class ShoeListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListFragment()
    }

    private val mainViewModel: MainViewModel by activityViewModels()
    private val loginViewModel: LoginViewModel by activityViewModels()
    private val shoeListViewModel: ShoeListViewModel by viewModels()
    private lateinit var viewBinding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)
        setHasOptionsMenu(true)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginViewModel.getAuthenticationState().observe(viewLifecycleOwner, Observer { state ->
            when(state) {
                AuthenticationState.AUTHENTICATED -> showWelcomeMessage()
                AuthenticationState.AUTHENTICATION_REFUSED -> findNavController().popBackStack()
                else -> findNavController().navigate(R.id.onboarding_nav_graph)
            }
        })

        viewBinding.lifecycleOwner = viewLifecycleOwner
        viewBinding.mainViewModel = mainViewModel
        viewBinding.shoeListViewModel = shoeListViewModel

        shoeListViewModel.addShoeEvent.observe(viewLifecycleOwner, Observer { shouldAdd ->
            if (shouldAdd) {
                shoeListViewModel.markAddShoeEventComplete()
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
            }
        })

        mainViewModel.getShoeList().observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList ?: return@Observer
            viewBinding.shoesListLayout.removeAllViews()
            shoeList.forEach { addShowView(it) }
        })
    }

    private fun addShowView(shoe: Shoe) {
        val shoeViewBinding = DataBindingUtil.inflate<ShoeListItemLayoutBinding>(layoutInflater, R.layout.shoe_list_item_layout,null, false)
        shoeViewBinding.shoe = shoe
        viewBinding.shoesListLayout.addView(shoeViewBinding.root.rootView, 0)
    }

    private fun showWelcomeMessage() {
        Toast.makeText(context, getString(R.string.shoe_list_fragment_welcome_msg), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_shoe_list_fragment, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_logout).isVisible = loginViewModel.getAuthenticationState().value!! == AuthenticationState.AUTHENTICATED
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                loginViewModel.logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
