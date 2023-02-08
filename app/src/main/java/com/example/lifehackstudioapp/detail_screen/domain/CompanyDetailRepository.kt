package com.example.lifehackstudioapp.detail_screen.domain


interface CompanyDetailRepository {

    suspend fun getCompaniesList(): List<CompanyDetailModel>

    fun setCompanyId(companyId: String)

}