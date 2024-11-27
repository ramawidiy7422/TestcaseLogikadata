package com.example.testcarelogikadata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab, container, false)
        val textView = view.findViewById<TextView>(R.id.tabTextView)
        textView.text = arguments?.getString(ARG_TAB_TITLE)
        return view
    }

    companion object {
        private const val ARG_TAB_TITLE = "tab_title"

        fun newInstance(title: String): TabFragment {
            val fragment = TabFragment()
            val args = Bundle()
            args.putString(ARG_TAB_TITLE, title)
            fragment.arguments = args
            return fragment
        }
    }
}