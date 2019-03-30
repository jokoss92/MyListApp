package id.ac.mercubuana.joko_ss.mylistapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class UserAdapter(
    val firstNames: Array<String>,
    val lastNames: Array<String>,
    val avatars: Array<String>
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item_layout, parent, false) as View
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return firstNames.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_first_name.text = firstNames[position]
        val lastName = " ${lastNames[position]}"
        holder.tv_last_name.text = lastName
        Picasso.get()
            .load(avatars[position])
            .placeholder(R.mipmap.ic_launcher)// if load failed will using placeholder
            .into(holder.iv_avatar);
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tv_first_name = view.findViewById<TextView>(R.id.tv_first_name)
        val tv_last_name = view.findViewById<TextView>(R.id.tv_last_name)
        val iv_avatar = view.findViewById<ImageView>(R.id.iv_avatar)
    }

}
