package com.example.myapplicationsecondmonthtask

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object FullListFragmentRepository : LiveData<List<Posts>>() {

    var list = MutableLiveData <ArrayList <Posts>>()
    var item = MutableLiveData <Posts>()

    fun getFullData () : MutableLiveData<ArrayList <Posts>> {
        val call: Call<ArrayList<Posts>> = RetrofitInstance.api.getPosts()
        call.enqueue(object : Callback<ArrayList<Posts>> {
            override fun onResponse(
                call: Call<ArrayList<Posts>>,
                response: Response<ArrayList<Posts>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                        list.value = response.body()
                }
            }
            override fun onFailure(call: Call<ArrayList<Posts>>, t: Throwable) {
                Log.e(ContentValues.TAG, "Response Not Successful")
            }
        })
    return list
    }

    fun getSeparateData () : MutableLiveData < Posts> {
        val call: Call<Posts> = RetrofitInstance.api.getSeparatePost()
        call.enqueue(object : Callback<Posts> {
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                if (response.isSuccessful && response.body() != null) {
                    item.value = response.body()
                }
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Log.e(ContentValues.TAG, "Response Not Successful")
            }
        })
    return item}
}
