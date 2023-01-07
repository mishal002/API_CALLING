package com.example.api_calling.Api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_calling.Activity.MainActivity
import com.example.api_calling.R
import com.example.apicalling.Retrofit.RetroApiModelItem

class ApiAdapter(val activity: MainActivity, val l1: List<RetroApiModelItem>) : RecyclerView.Adapter<ApiAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(activity).inflate(R.layout.itemfile,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userid.text = l1[position].id.toString()
        holder.id.text = l1[position].category.toString()
        holder.title_txt.text = l1[position].title.toString()
        holder.body_txt.text = l1[position].price.toString()
        holder.description_txt.text = l1[position].description.toString()

        Glide.with(activity)  //2
            .load(l1[position].image) //3
            .centerCrop() //4
            .into(holder.img) //8

    }

    override fun getItemCount(): Int {
        return l1.size
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var userid = itemView.findViewById<TextView>(R.id.userid_txt)
        var id = itemView.findViewById<TextView>(R.id.id_txt)
        var title_txt = itemView.findViewById<TextView>(R.id.title_txt)
        var body_txt = itemView.findViewById<TextView>(R.id.body_txt)
        var img = itemView.findViewById<ImageView>(R.id.img)
        var description_txt = itemView.findViewById<TextView>(R.id.description_txt)
    }
}