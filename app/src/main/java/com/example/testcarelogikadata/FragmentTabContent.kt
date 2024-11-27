package com.example.testcarelogikadata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testcarelogikadata.databinding.FragmentTabContentBinding

class FragmentTabContent(private val tabTitle: String) : Fragment() {

    private var _binding: FragmentTabContentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTabContentBinding.inflate(inflater, container, false)

        // Set up RecyclerView with Adapter
        val products = generateDummyProducts()
        val adapter = TabContentAdapter(products)
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun generateDummyProducts(): List<Product> {
        return listOf(
            Product(R.drawable.ic_pcgaming, "PC Gaming Core i5", "Rp11.975.700", "Kota Bandung"),
            Product(R.drawable.ic_pod, "Button Set San", "Rp356.250", "Kab. Sleman"),
            Product(R.drawable.ic_vrk, "18650 Battery Wrap", "Rp1.700", "Jakarta Timur"),
            Product(R.drawable.ic_oli_mpx, "Oli MPX 2 Matic", "Rp30.000", "Kota Tangerang"),
            Product(R.drawable.ic_launcher_background, "PC Gaming Core i5", "Rp11.975.700", "Kota Bandung"),
            Product(R.drawable.ic_launcher_background, "Button Set San", "Rp356.250", "Kab. Sleman"),
            Product(R.drawable.ic_launcher_background, "18650 Battery Wrap", "Rp1.700", "Jakarta Timur"),
            Product(R.drawable.ic_launcher_background, "Oli MPX 2 Matic", "Rp30.000", "Kota Tangerang")
        )
    }
}