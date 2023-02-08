package com.example.lifehackstudioapp.detail_screen.domain




interface CompanyDetailRepository {

    suspend fun getCompanyDetail(companyId: String): CompanyDetailModel

}