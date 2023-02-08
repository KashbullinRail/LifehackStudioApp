package com.example.lifehackstudioapp.main_screen.data.model

import com.example.lifehackstudioapp.main_screen.domain.CompaniesModel
import com.example.lifehackstudioapp.main_screen.domain.CompaniesRepository


class CompaniesRemoteRepositoryImpl() : CompaniesRepository {

    override suspend fun getCompaniesList(): List<CompaniesModel> {
        TODO("Not yet implemented")
    }

}