package com.example.lifehackstudioapp.detail_screen.data

import com.example.lifehackstudioapp.detail_screen.data.model.CompanyDetailRemoteModel


class CompanyDetailRemoteSource(private val api: CompanyDetailAPI) {

    companion object {
        var id = ""
    }

    suspend fun getCompaniesList(): List<CompanyDetailRemoteModel> {
        return api.getCompaniesList(
            id = id
        )
    }

    fun setCompanyId(companyId: String) {
        id = companyId
    }

}
