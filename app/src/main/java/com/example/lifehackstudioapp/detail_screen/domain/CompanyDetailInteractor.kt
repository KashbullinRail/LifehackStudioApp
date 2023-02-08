package com.example.lifehackstudioapp.detail_screen.domain

import com.example.lifehackstudioapp.base.attempt


class CompanyDetailInteractor(private val repository: CompanyDetailRepository) {

    suspend fun getCompanyDetail(companyId: String) = attempt {
        repository.getCompanyDetail(companyId)
    }

}



