package com.lifeistech.android.musicalinstrument

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import values.Inst

class InstListAdapter(private val context: Context, private val instList: List<Inst>) :
    RecyclerView.Adapter<InstListAdapter.InstListViewHolder>() {

    private val mediaPlayer:MediaPlayer = MediaPlayer.create(context, R.raw.piano)

    class InstListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val explainView: TextView = view.findViewById(R.id.explainView)
        val playView: ImageView = view.findViewById(R.id.playView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstListViewHolder =
        InstListViewHolder(LayoutInflater.from(context).inflate(R.layout.items, parent, false))

    override fun getItemCount(): Int = instList.size

    override fun onBindViewHolder(holder: InstListViewHolder, position: Int) {
        holder.imageView.setImageResource(instList[position].imageId)
        holder.explainView.text = instList[position].name
        holder.playView.setOnClickListener {
            mediaPlayer.start()
        }
    }
}
