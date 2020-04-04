package com.example.sampleappbyme.main.ui

import androidx.cardview.widget.CardView

interface CardAdapter {

    fun getBaseElevation(): Float
    fun getCardViewAt(position: Int): CardView
    fun getCount(): Int

    companion object {
        const val MAX_ELEVATION_FACTOR = 8
    }
}