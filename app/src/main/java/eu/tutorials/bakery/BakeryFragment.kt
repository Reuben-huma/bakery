package eu.tutorials.bakery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import eu.tutorials.bakery.databinding.FragmentBakeryBinding
import eu.tutorials.bakery.model.BakeryViewModel

class BakeryFragment : Fragment() {

    private lateinit var binding: FragmentBakeryBinding
    private val viewModel: BakeryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBakeryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            bakeryFragment = this@BakeryFragment
            bakeryViewModel = viewModel
        }
    }

    fun onDessertClick() {
        if(!viewModel.setDessert()) { Toast.makeText(requireContext(), "Bakery is cleaned out.", Toast.LENGTH_SHORT).show() }
    }
}