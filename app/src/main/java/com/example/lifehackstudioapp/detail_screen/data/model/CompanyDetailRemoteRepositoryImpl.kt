package com.example.lifehackstudioapp.detail_screen.data.model

import com.example.lifehackstudioapp.detail_screen.data.CompanyDetailRemoteSource
import com.example.lifehackstudioapp.detail_screen.data.toDomain
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailModel
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailRepository
import com.example.lifehackstudioapp.main_screen.data.CompaniesRemoteSource
import com.example.lifehackstudioapp.main_screen.data.toDomain
import com.example.lifehackstudioapp.main_screen.domain.CompaniesRepository
import com.example.lifehackstudioapp.main_screen.domain.CompanyModel


class CompanyDetailRemoteRepositoryImpl(private val source: CompanyDetailRemoteSource) : CompanyDetailRepository {

    override suspend fun getCompanyDetail(): CompanyDetailModel {
       return source.getCompanyDetail().toDomain()
    }

}