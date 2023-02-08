package com.example.lifehackstudioapp.main_screen.data

import com.example.lifehackstudioapp.main_screen.data.model.CompanyRemoteModel


class CompaniesRemoteSource(private val api: CompaniesAPI) {

    suspend fun getCompaniesList(): List<CompanyRemoteModel> {
        return api.getCompaniesList()
    }

}
