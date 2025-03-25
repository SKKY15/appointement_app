package com.example.appointmenapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(
    val context : Context,
    val data : ArrayList<Doctor>
) : RecyclerView.Adapter<DoctorViewHolder>() {

    var onItemClick : ((Doctor) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        return DoctorViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.rows_doctor, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size;
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = data[position]
        holder.doctorname.text = doctor.name
        holder.doctoriamge.setImageResource(doctor.imagedctr)
        holder.doctorspeciality.text = doctor.speciality
        holder.doctorcostperhour.text = doctor.costperhour

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(doctor)
        }
    }
}