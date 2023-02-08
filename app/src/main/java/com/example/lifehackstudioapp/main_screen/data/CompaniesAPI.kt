package com.example.lifehackstudioapp.main_screen.data

import com.example.lifehackstudioapp.main_screen.data.model.CompanyRemoteModel
import retrofit2.http.*


interface CompaniesAPI {

    @GET("test.php")
    suspend fun getCompaniesList(): List<CompanyRemoteModel>

}