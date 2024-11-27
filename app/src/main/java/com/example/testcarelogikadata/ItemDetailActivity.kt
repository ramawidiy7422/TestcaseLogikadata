package com.example.testcarelogikadata

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_item_detail_activity)

        // Get item name from intent
        val itemName = intent.getStringExtra("ITEM_NAME") ?: "Item Detail"

        // Set the item name to the TextView
        val itemTitle = findViewById<TextView>(R.id.item_title)
        itemTitle.text = itemName
    }
}