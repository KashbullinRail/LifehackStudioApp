package com.example.lifehackstudioapp.detail_screen.data.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class CompanyDetailRemoteModel(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("img")
    val img: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("www")
    val www: String?,
    @SerializedName("phone")
    val phone: String?
)