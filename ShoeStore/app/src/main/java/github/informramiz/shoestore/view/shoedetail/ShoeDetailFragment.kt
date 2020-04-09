package github.informramiz.shoestore.view.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import github.informramiz.shoestore.databinding.ShoeDetailFragmentBinding

class ShoeDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeDetailFragment()
    }

    private val viewModel: ShoeDetailViewModel by activityViewModels()
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
        viewBinding.viewModel = viewModel
    }

}
