package com.soluone.com.maishamedstest.data

import com.soluone.com.maishamedstest.domain.Post
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface RestInterface {
    @GET("posts")
    fun fetchPosts(): Observable<ArrayList<Post>>
}