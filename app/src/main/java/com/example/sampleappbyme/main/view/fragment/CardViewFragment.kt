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
import com.example.sampleappbyme.main.ui.card.CardAdapter
import com.example.sampleappbyme.main.ui.card.CardItem
import com.example.sampleappbyme.main.ui.card.CardPagerAdapter

class CardViewFragment : Fragment() {

    companion object {
        fun newInstance() =
            CardViewFragment()
    }
    
    private lateinit var binding: CardViewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = CardViewFragmentBinding.inflate(inflater, container, false)

        val testCardAdapter =
            CardPagerAdapter(activity!!.applicationContext)
        testCardAdapter.addCardItem(
            CardItem(
                "First Card",
                "First Card"
            )
        )
        testCardAdapter.addCardItem(
            CardItem(
                "Second Card",
                "Second Card"
            )
        )
        testCardAdapter.addCardItem(
            CardItem(
                "Third Card",
                "Third Card"
            )
        )
        testCardAdapter.addCardItem(
            CardItem(
                "Forth Card",
                "Forth Card"
            )
        )
        testCardAdapter.addCardItem(
            CardItem(
                "Fifth Card",
                "Fifth Card"
            )
        )

        var mLastOffset = 0f

        binding.cardViewPager.adapter = testCardAdapter
        binding.cardViewPager.offscreenPageLimit = 5
        binding.cardViewPager.currentItem = 0
        binding.mainDots.setupWithViewPager(binding.cardViewPager)
        binding.cardViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                val realCurrentPosition: Int
                val nextPosition: Int
                val baseElevation: Float = (binding.cardViewPager.adapter as CardPagerAdapter).getBaseElevation()
                val realOffset: Float
                val goingLeft: Boolean = mLastOffset > positionOffset

                if (goingLeft) {
                    realCurrentPosition = position + 1
                    nextPosition = position
                    realOffset = 1 - positionOffset
                } else {
                    nextPosition = position + 1
                    realCurrentPosition = position
                    realOffset = positionOffset
                }

                if (nextPosition > (binding.cardViewPager.adapter as CardPagerAdapter).count - 1
                    || realCurrentPosition > (binding.cardViewPager.adapter as CardPagerAdapter).count - 1) {
                    return
                }

                val currentCard: CardView = (binding.cardViewPager.adapter as CardPagerAdapter).getCardViewAt(realCurrentPosition)

                currentCard.scaleX = (1 + 0.1 * (1 - realOffset)).toFloat()
                currentCard.scaleY = (1 + 0.1 * (1 - realOffset)).toFloat()

                currentCard.cardElevation = baseElevation + (baseElevation
                        * (CardAdapter.MAX_ELEVATION_FACTOR - 1) * (1 - realOffset))

                val nextCard: CardView = (binding.cardViewPager.adapter as CardPagerAdapter).getCardViewAt(nextPosition)

                Log.d("scrollTest", "realCurrent : $realCurrentPosition nextPosition : $nextPosition")

                nextCard.scaleX = (1 + 0.1 * realOffset).toFloat()
                nextCard.scaleY = (1 + 0.1 * realOffset).toFloat()

                nextCard.cardElevation = baseElevation + (baseElevation
                        * (CardAdapter.MAX_ELEVATION_FACTOR - 1) * realOffset)

                mLastOffset = positionOffset
            }

            override fun onPageSelected(position: Int) {

            }
        })

        return binding.root
    }
}
