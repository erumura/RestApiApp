package com.example.restapiapp

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


private class UsersAdapter(context: Context, userListResponseData: List<Post>) :
    RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {
    var context: Context
    var userListResponseData: List<Post>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersViewHolder {

       val view: View = LayoutInflater.from(context).inflate(R.layout.user_list_items)
       return UsersViewHolder(view)

    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        
        holder.Name.TextView = "Name: " + userListResponseData[position].name

        holder.Seat.TextView = "seat: " + userListResponseData[position].seat

        holder.Group.TextView = "Group: " + userListResponseData[position].group

    
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                // display a toast with user name
                Toast.makeText(
                    context,
                    userListResponseData[position].getName(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun getItemCount(): Int {
        return userListResponseData.size 
    }

    internal inner class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // init the item view's
     lateinit   var name: TextView
       lateinit var seat: TextView
       lateinit var group: TextView

        init {
            // get the reference of item view's
            name = itemView.findViewById(R.id.Name)
            seat = itemView.findViewById(R.id.Seat)
            group = itemView.findViewById(R.id.Group)
        }
    }

    init {
        this.userListResponseData = userListResponseData
        this.context = context
    }
}