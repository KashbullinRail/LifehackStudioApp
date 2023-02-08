package com.example.lifehackstudioapp.main_screen.domain



interface CompaniesListRepository {

    suspend fun getCompaniesList(): List<CompaniesListModel>

}