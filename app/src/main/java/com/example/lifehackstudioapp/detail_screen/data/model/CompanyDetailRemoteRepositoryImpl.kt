package com.example.lifehackstudioapp.detail_screen.data.model

import com.example.lifehackstudioapp.detail_screen.data.CompanyDetailRemoteSource
import com.example.lifehackstudioapp.detail_screen.data.toDomain
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailModel
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailRepository


class CompanyDetailRemoteRepositoryImpl(private val source: CompanyDetailRemoteSource) :
    CompanyDetailRepository {

    override suspend fun getCompaniesList(): List<CompanyDetailModel> {
        return source.getCompaniesList().map {
            it.toDomain()
        }
    }

    override fun setCompanyId(companyId: String) {
        source.setCompanyId(companyId)
    }

}