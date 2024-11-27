package com.example.testcarelogikadata

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    // Jumlah tab yang ingin ditampilkan
    override fun getItemCount(): Int {
        return 6
    }

    // Fragment yang akan ditampilkan pada setiap tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentTabContent("For Widi")
            1 -> FragmentTabContent("Official Store")
            2 -> FragmentTabContent("Elektronik")
            3 -> FragmentTabContent("Dekat Kamu")
            4 -> FragmentTabContent("Mirip yang Kamu Cek")
            5 -> FragmentTabContent("Happy Hour")
            else -> FragmentTabContent("Unknown")
        }
    }
}