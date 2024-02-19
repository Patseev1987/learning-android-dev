package com.example.recycleviewmovies.apiRetrofit

import com.example.recycleviewmovies.pojo.RequestMovies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("accept: application/json", "X-API-KEY: 2QZG1K7-12N4H9J-JN6VHMT-5JQ44VF")
    @GET("movie")
    fun loadMovies(): Single<RequestMovies>
}