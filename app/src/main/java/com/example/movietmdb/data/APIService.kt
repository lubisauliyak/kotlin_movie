package com.example.movietmdb.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/3/movie/popular?api_key=e670a93fe5bb501b22aaae903837b99b")
    suspend fun getTodoList(): Response<DataMovie>
}