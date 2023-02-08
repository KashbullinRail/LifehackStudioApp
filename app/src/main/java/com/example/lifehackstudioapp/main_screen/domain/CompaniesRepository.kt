package com.example.lifehackstudioapp.main_screen.domain



interface CompaniesRepository {

    suspend fun getCompaniesList(): List<CompanyModel>

}