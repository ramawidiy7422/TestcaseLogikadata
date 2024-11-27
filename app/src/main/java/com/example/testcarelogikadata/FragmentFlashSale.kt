package com.example.testcarelogikadata

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentFlashSale : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_flash_sale, container, false)

        // Handle Timer
        val timerText = view.findViewById<TextView>(R.id.timer_text)
        startCountdown(timerText, 1 * 60 * 60 * 1000) // 1 hour countdown

        // Handle Navigation for Arrow
        val arrowButton = view.findViewById<ImageView>(R.id.arrow_button)
        arrowButton.setOnClickListener {
            navigateToPage(ArrowActivity::class.java)
        }

        // Handle Clicks for Items
        val item1 = view.findViewById<ImageView>(R.id.item1)
        val item2 = view.findViewById<ImageView>(R.id.item2)
        val item3 = view.findViewById<ImageView>(R.id.item3)
        val item4 = view.findViewById<ImageView>(R.id.item4)

        item1.setOnClickListener { navigateToPage(ItemDetailActivity::class.java, "Item 1") }
        item2.setOnClickListener { navigateToPage(ItemDetailActivity::class.java, "Item 2") }
        item3.setOnClickListener { navigateToPage(ItemDetailActivity::class.java, "Item 3") }
        item4.setOnClickListener { navigateToPage(ItemDetailActivity::class.java, "Item 4") }

        return view
    }

    private fun startCountdown(timerText: TextView, duration: Long) {
        object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val hours = millisUntilFinished / (1000 * 60 * 60)
                val minutes = (millisUntilFinished / (1000 * 60)) % 60
                val seconds = (millisUntilFinished / 1000) % 60
                timerText.text = String.format("%d:%02d:%02d", hours, minutes, seconds)
            }

            override fun onFinish() {
                timerText.text = "Expired"
            }
        }.start()
    }

    private fun navigateToPage(activityClass: Class<*>, itemName: String? = null) {
        val intent = Intent(activity, activityClass)
        itemName?.let { intent.putExtra("ITEM_NAME", it) }
        startActivity(intent)
    }
}