package com.example.mart.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mart.msgshareapp.models.Hobby
import com.example.mart.msgshareapp.R
import com.example.mart.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*


/*
* Create adapter for mapping on layout of list items
*/

// Adapter Constructor argument receive context and List of Model it will show in List item
// Extend -> RecyclerView.Adapter<??????????.MyViewHolder>
class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    // 3 method it overrided by this class
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby,position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                context.showToast(currentHobby!!.title+" Clicked!")
//                Toast.makeText(context,currentHobby!!.title+" Clicked!", Toast.LENGTH_SHORT).show()
            }
            itemView.imgShare.setOnClickListener {
                currentHobby?.let {
                    var message: String = "My hobby is "+ currentHobby!!.title
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,message)
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent, "Select application : "))
                }
            }
        }
        fun setData(hobby: Hobby?, pos:Int){
            hobby?.let {
                itemView.txvTitle.text = hobby.title
                this.currentHobby = hobby
                this.currentPosition = pos
            }
        }
    }
}