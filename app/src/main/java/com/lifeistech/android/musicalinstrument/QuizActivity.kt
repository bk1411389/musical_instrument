package com.lifeistech.android.musicalinstrument

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class QuizActivity : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.activity_quiz, container, false)
    }
}
