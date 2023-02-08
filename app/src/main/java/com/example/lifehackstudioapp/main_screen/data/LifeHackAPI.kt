package com.example.lifehackstudioapp.main_screen.data

import com.example.lifehackstudioapp.main_screen.data.model.CompanyRemoteModel
import retrofit2.http.*


interface LifeHackAPI {

    @GET("test.php")
    suspend fun getCompanies(
    ): List<CompanyRemoteModel>


    @GET("test.php")
    suspend fun getSelectCompany(
        @Query("id") id: String = "",
    ): List<CompanyRemoteModel>
}