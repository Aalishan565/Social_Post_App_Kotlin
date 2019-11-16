package com.yasma.gateway

import com.yasma.dto.Post
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("posts")
    fun postResponse(): Call<List<Post>>
}