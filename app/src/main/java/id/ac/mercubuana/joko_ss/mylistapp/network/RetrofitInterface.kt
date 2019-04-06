package id.ac.mercubuana.joko_ss.mylistapp.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitInterface {

    @GET("users")
    fun getUsers(
        @Query("per_page") perPage: String
    ): Call<JsonObject>
}