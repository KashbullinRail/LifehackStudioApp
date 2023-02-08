package com.example.lifehackstudioapp.main_screen.data

import com.example.lifehackstudioapp.main_screen.data.model.CompaniesRemoteModel


class CompaniesRemoteSource(private val api: LifeHackAPI) {

    suspend fun getArticles(): CompaniesRemoteModel {
        return api.getArticles()
    }

}
