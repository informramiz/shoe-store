package github.informramiz.shoestore.view.onboarding.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import github.informramiz.shoestore.R
import github.informramiz.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {

    companion object {
        fun newInstance() =
            InstructionsFragment()
    }

    private lateinit var viewBinding: InstructionsFragmentBinding
    private val viewModel: InstructionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.instructions_fragment, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.lifecycleOwner = this
        viewBinding.viewModel = viewModel
        viewModel.eventInstructionsDone.observe(viewLifecycleOwner, Observer { isDone ->
            if (isDone) {
                findNavController().popBackStack()
                viewModel.eventInstructionsDoneComplete()
            }
        })
    }
}
