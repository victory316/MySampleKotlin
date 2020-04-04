package com.example.sampleappbyme.main.ui

import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class CardFragmentPagerAdapter : CardAdapter, FragmentStatePagerAdapter {

    private var mFragments: MutableList<CardFragment> = mutableListOf()
    private var mBaseElevation = 0f

    constructor(fm: FragmentManager, baseElevation: Float, behavior: Int): super(fm, behavior) {
        mBaseElevation = baseElevation

        for (indices in 0..5) {
            addCardFragment(CardFragment())
        }
    }

    override fun getBaseElevation(): Float {
        TODO("Not yet implemented")
    }

    override fun getCardViewAt(position: Int): CardView {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Fragment {
        TODO("Not yet implemented")
    }

    fun addCardFragment(fragment: CardFragment) {
        mFragments.add(fragment)
    }
}