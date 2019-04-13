package id.ac.mercubuana.joko_ss.mylistapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import id.ac.mercubuana.joko_ss.mylistapp.model.DataItem

class UserAdapter(
    var users: ArrayList<DataItem?>
    ) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        context = parent.context
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item_layout, parent, false) as View
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return users?.size ?: 0

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //init value
        val user = users!![position]
        var firstName = user!!.firstName
        var lastName = user.lastName
        var avatar = user.avatar
        if (users != null && users[position] != null) {
            val currentUser = users[position]
            lastName = " ${currentUser!!.lastName}"
            avatar = currentUser.avatar!!
            firstName = currentUser.firstName!!
        }

        //set value
        holder.tv_first_name.text = firstName
        holder.tv_last_name.text = lastName

        Picasso.get()
            .load(avatar)
            .placeholder(R.mipmap.ic_launcher)// if load failed will using placeholder
            .into(holder.iv_avatar)

        holder.view.setOnClickListener {
                gotoDetailsActivity(user)

        }
    }

    private fun gotoDetailsActivity(user: DataItem){
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("userData", user)
        context.startActivity(intent)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tv_first_name = view.findViewById<TextView>(R.id.tv_first_name)
        val tv_last_name = view.findViewById<TextView>(R.id.tv_last_name)
        val iv_avatar = view.findViewById<ImageView>(R.id.iv_avatar)
    }

}
