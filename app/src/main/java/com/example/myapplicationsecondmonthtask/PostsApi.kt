package com.example.myapplicationsecondmonthtask

import retrofit2.Call
import retrofit2.http.GET

interface PostsApi {

    @GET("/posts")
    fun getPosts(): Call<ArrayList<Posts>>
    @GET("/posts/")
    fun getSeparatePost() : Call <Posts>
}