package com.example.lifehackstudioapp.main_screen.data.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class CompanyRemoteModel(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("img")
    val image: String?,
)