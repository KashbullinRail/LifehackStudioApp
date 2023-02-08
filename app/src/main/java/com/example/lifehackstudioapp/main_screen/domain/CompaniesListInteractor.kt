package com.example.lifehackstudioapp.main_screen.domain




class CompaniesListInteractor(private val repository: CompaniesListRepository) {

    suspend fun getCompaniesList() = attempt {
        repository.getCompaniesList()
    }

}



