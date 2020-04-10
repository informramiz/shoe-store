package github.informramiz.shoestore.view.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import github.informramiz.shoestore.databinding.ShoeDetailFragmentBinding
import github.informramiz.shoestore.model.entities.Shoe
import github.informramiz.shoestore.view.home.MainViewModel

class ShoeDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeDetailFragment()
    }

    private val shoeDetailViewModel: ShoeDetailViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var viewBinding: ShoeDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = ShoeDetailFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        viewBinding.viewModel = shoeDetailViewModel
        viewBinding.shoe = Shoe()


        shoeDetailViewModel.setShoe(ShoeDetailFragmentArgs.fromBundle(arguments!!).shoe)
        shoeDetailViewModel.addShoeEvent.observe(viewLifecycleOwner, Observer { event ->
            event ?: return@Observer
            when (event) {
                is AddShoeEvent.AddNewShoe -> {
                    mainViewModel.addShoe(event.shoe)
                    findNavController().popBackStack()
                    shoeDetailViewModel.markAddShoeEventComplete()
                }
                AddShoeEvent.AddShoeCompleted -> {}
                is AddShoeEvent.AddShoeError -> {
                    Toast.makeText(requireContext(), event.error, Toast.LENGTH_SHORT).show()
                    shoeDetailViewModel.markAddShoeEventComplete()
                }
                is AddShoeEvent.AddShoeCanceled -> {
                    findNavController().popBackStack()
                    shoeDetailViewModel.markAddShoeEventComplete()
                }
            }.exhaustive
        })
    }
}
