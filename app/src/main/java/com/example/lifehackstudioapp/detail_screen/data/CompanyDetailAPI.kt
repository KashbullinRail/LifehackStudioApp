package com.example.lifehackstudioapp.detail_screen.data

import com.example.lifehackstudioapp.detail_screen.data.model.CompanyDetailRemoteModel
import retrofit2.http.*


interface CompanyDetailAPI {

    @GET("test.php")
    suspend fun getCompaniesList(
        @Query("id") id: String,
    ): List<CompanyDetailRemoteModel>

}