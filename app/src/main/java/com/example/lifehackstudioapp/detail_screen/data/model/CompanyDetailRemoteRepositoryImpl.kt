package com.example.lifehackstudioapp.detail_screen.data.model

import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailModel
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailRepository
import com.example.lifehackstudioapp.main_screen.data.CompaniesRemoteSource
import com.example.lifehackstudioapp.main_screen.domain.CompaniesRepository
import com.example.lifehackstudioapp.main_screen.domain.CompanyModel


class CompanyDetailRemoteRepositoryImpl(private val source: CompaniesRemoteSource) : CompanyDetailRepository {

    override suspend fun getCompanyDetail(): CompanyDetailModel {
        TODO("Not yet implemented")
    }

}