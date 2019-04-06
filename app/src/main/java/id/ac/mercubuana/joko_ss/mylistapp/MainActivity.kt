package id.ac.mercubuana.joko_ss.mylistapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import id.ac.mercubuana.joko_ss.mylistapp.model.DataItem
import id.ac.mercubuana.joko_ss.mylistapp.model.UsersResponse
import id.ac.mercubuana.joko_ss.mylistapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUsers()

//        initView()

    }

    private fun getUsers() {
        val service = RetrofitService()
        service.getUser(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    val userData = Gson().fromJson(data.toString(), UsersResponse::class.java)
                    initView(userData.data)
                    Log.d("tag", "responsennya : ${data}")
                }
            }

            override fun onFailure(call: Call<JsonObject>, error: Throwable) {
                Log.e("tag", "errornya ${error.message}")
            }
        })

    }

    private fun initView(data: List<DataItem?>?) {
        val userListView = findViewById<RecyclerView>(R.id.user_list_view)
        userListView.adapter = UserAdapter(data)
        userListView.layoutManager = LinearLayoutManager(this)
    }
}


