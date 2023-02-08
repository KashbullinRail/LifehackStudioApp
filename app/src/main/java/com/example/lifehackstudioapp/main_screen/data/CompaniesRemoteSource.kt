package com.example.lifehackstudioapp.main_screen.data

import com.example.lifehackstudioapp.main_screen.data.model.CompanyRemoteModel


class CompaniesRemoteSource(private val api: LifeHackAPI) {

    suspend fun getCompanyDetail(): CompanyRemoteModel {
        return api.getCompanyDetail(
            id =
        )
    }

}
