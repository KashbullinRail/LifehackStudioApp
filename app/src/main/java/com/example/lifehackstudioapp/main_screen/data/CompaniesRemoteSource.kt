package com.example.lifehackstudioapp.main_screen.data

import com.example.lifehackstudioapp.main_screen.data.model.CompanyRemoteModel


class CompaniesRemoteSource(private val api: LifeHackAPI) {

    suspend fun getArticles(): List<CompanyRemoteModel> {
        return api.getCompanies()
    }

}
