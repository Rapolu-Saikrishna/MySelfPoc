package com.selfpoc.mypocwork.data.remote

import com.selfpoc.mypocwork.domain.model.LoginRequest
import com.selfpoc.mypocwork.domain.model.LoginResponse
import com.selfpoc.mypocwork.domain.model.NewsArticle
import com.selfpoc.mypocwork.domain.model.NewsDetail
import com.selfpoc.mypocwork.domain.model.RegisterRequest
import com.selfpoc.mypocwork.domain.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("916adae9-958b-4865-95c4-97ace6703717")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("d539bc0e-df77-4234-935c-db52dc3ea8a5")
    suspend fun register(@Body request: RegisterRequest): RegisterResponse

    @GET("7163ff51-6c7c-4afd-9186-d3d0cc589b46")
    suspend fun getNewsArticles(): List<NewsArticle>

    @GET("b8fc811b-81c5-49ad-8100-ba915d33315e/{id}")
    suspend fun getNewsDetail(@Path("id") id: String): NewsDetail
}