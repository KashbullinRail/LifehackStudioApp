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
    val description: String,
    @SerializedName("lat")
    val latitude: Long,
    @SerializedName("lon")
    val longitude: Long,
    @SerializedName("www")
    val websiteAddress: String,
    @SerializedName("phone")
    val phoneNumber: String
)