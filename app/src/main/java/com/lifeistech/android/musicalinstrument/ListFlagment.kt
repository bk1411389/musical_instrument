package com.lifeistech.android.musicalinstrument

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.flagment_list.*
import values.Inst

class ListFlagment : Fragment() {
    val instList = mutableListOf<Inst>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.flagment_list, container, false)
        val cxt : Context = view.context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        for (i in 0..10) {
            instList.add(Inst(R.drawable.music_piano, "piano", R.raw.VSQ_JINGLE_030_logo_piano))
        }

        recyclerView.adapter = InstListAdapter(cxt, instList)
        recyclerView.layoutManager = LinearLayoutManager(cxt)

        return  view
    }
}
