package com.example.movieapp.Adapter

import RvModels.Position
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.AboutActivity
import com.example.movieapp.EditActivity
import com.example.movieapp.R
import com.example.movieapp.models.User
import kotlinx.android.synthetic.main.item.view.*
import java.lang.Exception

class MyAdapter(var context: Context, val list: ArrayList<User>) : RecyclerView.Adapter<MyAdapter.Vh>() {
    inner class Vh(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(rvModels: User,position: Int){
            itemView.item_name.text = rvModels.name
            itemView.item_actor.text = rvModels.actor
            itemView.item_date.text = rvModels.date

            try {
                itemView.setOnClickListener {
                    Position.position = position
                    context.startActivity(Intent(context, AboutActivity::class.java))
                }
            }catch (e: Exception){
                Toast.makeText(context, "$e", Toast.LENGTH_SHORT).show()
            }

            itemView.item_edit.setOnClickListener {
                val intent = Intent(context, EditActivity::class.java)
                intent.putExtra("model",rvModels)
                intent.putExtra("position",position)
                context.startActivity(intent)

            }
            itemView.item_delete.setOnClickListener {
                MySharePreference.init(context)
                list.remove(list[position])
                MySharePreference.obektString = list
                notifyDataSetChanged()
                Toast.makeText(context, "O`chirildi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Vh {

        return Vh(
            LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyAdapter.Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int = list.size
}