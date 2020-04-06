package com.example.sampleappbyme.main.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager

import com.example.sampleappbyme.databinding.CardViewFragmentBinding
import com.example.sampleappbyme.databinding.TaskViewFragmentBinding
import com.example.sampleappbyme.main.ui.card.CardAdapter
import com.example.sampleappbyme.main.ui.card.CardItem
import com.example.sampleappbyme.main.ui.card.CardPagerAdapter

class TaskViewFragment : Fragment() {

    private lateinit var binding: TaskViewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = TaskViewFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}
