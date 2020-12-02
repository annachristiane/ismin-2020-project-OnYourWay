package com.ismin.projectapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LineAdapter(private var lines:ArrayList<Line>, private val favoriteListener:onFavoriteListener): RecyclerView.Adapter<LineViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_line, parent, false)
        return LineViewHolder(row)
    }

    override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
        val(status, name_line, shortname_groupoflines) = this.lines[position]

        holder.txvNameLine.text = name_line
        holder.txvShortNameGroupOfLine.text = shortname_groupoflines
        holder.txvStatus.text = status

        holder.unfavButton.setOnClickListener{
            favoriteListener.unfavFavorite(position)
            holder.unfavButton.visibility = View.GONE
            holder.favButton.visibility = View.VISIBLE
        }

        holder.favButton.setOnClickListener{
            favoriteListener.unfavFavorite(position)
            holder.unfavButton.visibility = View.VISIBLE
            holder.favButton.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return this.lines.size
    }

    fun updateList(lineList: ArrayList<Line>){
        lines = lineList
        notifyDataSetChanged()
    }
}
