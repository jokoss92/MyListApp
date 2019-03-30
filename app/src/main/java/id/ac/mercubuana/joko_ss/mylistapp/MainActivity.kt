package id.ac.mercubuana.joko_ss.mylistapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val someString = getString(R.string.testing)
//        val someTesting = getString(R.string.testing_again)
//        getString(R.string.testing)
        val firstNames = resources.getStringArray(R.array.first_names)
        val lastNames = resources.getStringArray(R.array.last_names)
        val avatars = resources.getStringArray(R.array.avatars)
//        setDefaultView(firstNames, lastNames, avatars)

        user_list_view.adapter = UserAdapter(firstNames, lastNames, avatars)
        user_list_view.layoutManager = LinearLayoutManager(this)


    }

//    private fun setDefaultView(firstNames: Array<String>, lastNames: Array<String>, avatars: Array<String>) {
////        val name = " ${lastNames[2]}"
////        first_name.text = firstNames[2]
////        last_name.text= name
////        Picasso.get()
////            .load(avatars[2])
////            .placeholder(R.mipmap.ic_launcher)// if load failed will using placeholder
////            .into(avatar);
//    }
}
