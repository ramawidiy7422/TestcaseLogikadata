package com.example.testcarelogikadata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set default fragment saat aplikasi dibuka
        replaceFragment(FragmentBuatKamu())

        // Listener untuk berpindah fragment saat tab di klik
        bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.nav_buat_kamu -> FragmentBuatKamu()
                R.id.nav_feed -> FragmentFeed()
                R.id.nav_store -> FragmentStore()
                R.id.nav_transaksi -> FragmentTransaksi()
                R.id.nav_akun -> FragmentAkun()
                else -> FragmentBuatKamu()
            }
            replaceFragment(fragment)
            true
        }
    }

    // Fungsi untuk mengganti fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}