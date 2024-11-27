package com.example.testcarelogikadata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testcarelogikadata.databinding.FragmentBuatKamuBinding
import com.google.android.material.tabs.TabLayoutMediator

class FragmentBuatKamu : Fragment() {

    private var _binding: FragmentBuatKamuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBuatKamuBinding.inflate(inflater, container, false)

        // Set up ViewPager2 with an Adapter
        val adapter = ViewPagerAdapter(requireActivity())
        binding.includeTabs.viewPager.adapter = adapter

        // Set up TabLayout with Tab Titles
        val tabTitles = listOf(
            "For Widi",
            "Official Store",
            "Elektronik",
            "Dekat Kamu",
            "Mirip yang Kamu Cek",
            "Happy Hour"
        )
        TabLayoutMediator(binding.includeTabs.tabLayout, binding.includeTabs.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}