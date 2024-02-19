package com.example.recycleviewmovies.pojo

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String,
    val poster:Poster,
    val rating:Rating,

)