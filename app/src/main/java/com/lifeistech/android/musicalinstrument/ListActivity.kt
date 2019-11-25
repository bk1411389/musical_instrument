package com.lifeistech.android.musicalinstrument

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : Fragment() {

    private val instList = listOf("a","i","u")
    private lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//        listView = findViewById(R.id.listView)
//        listView.setOnItemClickListener{parent, v, position, id ->
//            /* タップ時の挙動 */
//        }
//
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, instList)
//        listView.adapter = adapter
        return  inflater.inflate(R.layout.activity_list, container, false)
    }
}
