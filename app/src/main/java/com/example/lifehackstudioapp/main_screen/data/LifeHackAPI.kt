package com.example.lifehackstudioapp.main_screen.data

import com.example.lifehackstudioapp.main_screen.data.model.CompaniesRemoteModel
import retrofit2.http.*


interface LifeHackAPI {

    @GET("v2/top-headlines")
    suspend fun getArticles(
        @Query("id") id: String = "id",
    ): CompaniesRemoteModel

}