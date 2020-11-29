package com.ismin.projectapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var txvNameLine = itemView.findViewById<TextView>(R.id.r_line_txv_name_line)
    var txvShortNameGroupOfLine: TextView = itemView.findViewById(R.id.r_line_txv_shortname_groupoflines)
    var txvStatus: TextView = itemView.findViewById(R.id.r_line_txv_status)
}