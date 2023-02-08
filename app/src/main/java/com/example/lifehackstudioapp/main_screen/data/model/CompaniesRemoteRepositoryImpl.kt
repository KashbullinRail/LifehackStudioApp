package com.example.lifehackstudioapp.main_screen.data.model

import com.example.lifehackstudioapp.main_screen.data.CompaniesRemoteSource
import com.example.lifehackstudioapp.main_screen.data.toDomain
import com.example.lifehackstudioapp.main_screen.domain.CompanyModel
import com.example.lifehackstudioapp.main_screen.domain.CompaniesRepository


class CompaniesRemoteRepositoryImpl(private val source: CompaniesRemoteSource) : CompaniesRepository {

    override suspend fun getCompaniesList(): List<CompanyModel> {
        return source.getCompaniesList().map {
            it.toDomain()
        }
    }

}