package com.lifeistech.android.musicalinstrument

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_list -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.linearLayout, ListActivity())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_quiz -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.linearLayout, QuizActivity())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.linearLayout, SearchActivity())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        //初期表示
        supportFragmentManager.beginTransaction()
            .replace(R.id.linearLayout, ListActivity())
            .commit()
    }
}
