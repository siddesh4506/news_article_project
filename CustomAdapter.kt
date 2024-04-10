package com.example.articlesdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MyAdapter(private val data: List<Data>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(Data:Data){
            val title = view.findViewById<TextView>(R.id.tvTitle)
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            val description = view.findViewById<TextView>(R.id.tvDescription)

            title.text = Data.categories.get(position).title

            description.text = Data.categories.get(position).description

            Glide.with(view.context).load(Data.categories.get(position).image).centerCrop().into(imageView)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rvadapter, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }


}