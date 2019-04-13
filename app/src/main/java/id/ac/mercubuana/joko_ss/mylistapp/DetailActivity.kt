package id.ac.mercubuana.joko_ss.mylistapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import id.ac.mercubuana.joko_ss.mylistapp.model.DataItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val userData = intent.getSerializableExtra("userData") as DataItem

        //mapping si userData.firstname and lastname ke text view
        val tvNamaDetail = findViewById<TextView>(R.id.tvNamaDetail)
        tvNamaDetail.text = "${userData.firstName} ${userData.lastName}"
        //mapping si avatar ke image pake Picasso
        val imageAvatar = findViewById<ImageView>(R.id.ivAvatarDetail)
        Picasso.get()
            .load(userData.avatar)
            .placeholder(R.drawable.ic_launcher_foreground)// if load failed will using placeholder
            .into(imageAvatar)


        Toast.makeText( this, userData.firstName, Toast.LENGTH_SHORT).show()
    }
}
