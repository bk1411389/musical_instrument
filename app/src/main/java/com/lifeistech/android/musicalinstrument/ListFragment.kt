package com.lifeistech.android.musicalinstrument

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import values.Inst

class ListFragment : Fragment() {
    val instList = mutableListOf<Inst>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.flagment_list, container, false)
        val cxt : Context = view.context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        instList.add(Inst(R.drawable.music_piano, "ピアノ", R.raw.piano))
        instList.add(Inst(R.drawable.music_banjo, "バンジョー", R.raw.banjo))
        instList.add(Inst(R.drawable.music_tenor_saxophone, "サックス", R.raw.tenor_sax))
        instList.add(Inst(R.drawable.music_tynpani, "ティンパニー", R.raw.tynpani))
        instList.add(Inst(R.drawable.music_viola, "ヴィオラ", R.raw.viola))

        recyclerView.adapter = InstListAdapter(cxt, instList)
        recyclerView.layoutManager = LinearLayoutManager(cxt)

        return  view
    }
}
