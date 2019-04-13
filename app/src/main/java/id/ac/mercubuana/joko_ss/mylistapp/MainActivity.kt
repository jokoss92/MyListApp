package id.ac.mercubuana.joko_ss.mylistapp

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.AbsListView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonObject
import id.ac.mercubuana.joko_ss.mylistapp.model.DataItem
import id.ac.mercubuana.joko_ss.mylistapp.model.UsersResponse
import id.ac.mercubuana.joko_ss.mylistapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var userDataList: ArrayList<DataItem?> = ArrayList()
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUserData(true)
//        initView()

    }


    private fun getUserData(isFirstTime: Boolean) {
        RetrofitService().getUser(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    val userData = Gson().fromJson(data.toString(), UsersResponse::class.java)
                    userDataList.addAll(userData.data)
                    if (isFirstTime) {
                        initView(userDataList)
                    } else {
                        adapter.notifyDataSetChanged()
                    }
                    Log.d("tag", "responsennya : ${data}")
                }
            }

            override fun onFailure(call: Call<JsonObject>, error: Throwable) {
                Log.e("tag", "errornya ${error.message}")
            }
        })
    }

    private fun initView(data: ArrayList<DataItem?>) {
        adapter = UserAdapter(data)
        val userListView = findViewById<RecyclerView>(R.id.user_list_view)
        userListView.layoutManager = LinearLayoutManager(this)
        userListView.adapter = adapter

        setScrollListener(userListView);
    }

    private fun setScrollListener(userListView: RecyclerView) {
        userListView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Toast.makeText(applicationContext, "List sudah habis", Toast.LENGTH_SHORT).show()
                    getUserData( false)
                }
            }
        })
    }
}




