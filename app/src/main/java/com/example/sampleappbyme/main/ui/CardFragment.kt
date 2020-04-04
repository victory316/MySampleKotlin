package com.example.sampleappbyme.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.sampleappbyme.databinding.MainCardAdapterBinding

class CardFragment : Fragment() {
    private lateinit var mCardView: CardView
    private lateinit var binding: MainCardAdapterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = MainCardAdapterBinding.inflate(inflater,container,false)
        binding.cardView.maxCardElevation = binding.cardView.cardElevation * CardAdapter.MAX_ELEVATION_FACTOR

        return binding.root
    }

    fun getCardView(): CardView{
        return mCardView
    }
}