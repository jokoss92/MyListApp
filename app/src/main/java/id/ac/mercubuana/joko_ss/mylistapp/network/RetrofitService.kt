package id.ac.mercubuana.joko_ss.mylistapp.network

import com.google.gson.JsonObject
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * https://reqres.in/api/users?per_page=12-
 */

class RetrofitService {
    fun getService(): RetrofitInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create<RetrofitInterface>(RetrofitInterface::class.java)
    }

    fun getUser(callback: Callback<JsonObject>) {
        val getUserService = getService().getUsers("12")
        getUserService.enqueue(callback)
    }
}