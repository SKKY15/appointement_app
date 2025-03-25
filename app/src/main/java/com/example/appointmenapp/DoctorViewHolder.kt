package com.example.appointmenapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoctorViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val doctorname = itemView.findViewById<TextView>(R.id.name)
        val doctorspeciality = itemView.findViewById<TextView>(R.id.speciality)
        val doctorcostperhour = itemView.findViewById<TextView>(R.id.costperhour)
        val doctoriamge = itemView.findViewById<ImageView>(R.id.imagedctr)
}