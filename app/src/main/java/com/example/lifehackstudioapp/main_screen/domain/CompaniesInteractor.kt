package com.example.lifehackstudioapp.main_screen.domain

import com.example.newsfetcher.base.attempt


class CompaniesInteractor(private val repository: CompaniesRepository) {

    suspend fun getCompaniesList() = attempt {
        repository.getCompaniesList()
    }

}



