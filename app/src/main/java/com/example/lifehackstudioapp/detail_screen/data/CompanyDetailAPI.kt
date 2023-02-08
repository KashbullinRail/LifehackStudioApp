package com.example.lifehackstudioapp.detail_screen.data

import com.example.lifehackstudioapp.detail_screen.data.model.CompanyDetailRemoteModel
import com.example.lifehackstudioapp.main_screen.data.model.CompanyRemoteModel
import retrofit2.http.*


interface CompanyDetailAPI {

    @GET("test.php")
    suspend fun getCompanyDetail(
        @Query("id") id: String,
    ): CompanyDetailRemoteModel

}