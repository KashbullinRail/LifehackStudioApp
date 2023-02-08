package com.example.lifehackstudioapp.detail_screen.data

import com.example.lifehackstudioapp.detail_screen.data.model.CompanyDetailRemoteModel
import com.example.lifehackstudioapp.main_screen.data.model.CompanyRemoteModel


class CompanyDetailRemoteSource(private val api: CompanyDetailAPI) {

    suspend fun getCompanyDetail(companyId: String): CompanyDetailRemoteModel {
        return api.getCompanyDetail(
            id = companyId
        )
    }

}
