package com.example.recycleviewmovies.pojo

import com.google.gson.annotations.SerializedName

data class RequestMovies(
    @SerializedName("docs")
    val movies:List<Movie>
)