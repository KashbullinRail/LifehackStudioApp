package com.example.lifehackstudioapp.main_screen.di

import com.example.lifehackstudioapp.main_screen.data.CompaniesRemoteSource
import com.example.lifehackstudioapp.main_screen.data.LifeHackAPI
import com.example.lifehackstudioapp.main_screen.data.model.CompaniesRemoteRepositoryImpl
import com.example.lifehackstudioapp.main_screen.domain.CompaniesInteractor
import com.example.lifehackstudioapp.main_screen.domain.CompaniesRepository
import com.example.lifehackstudioapp.main_screen.presentation.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val mainScreenModule = module {

    single<LifeHackAPI> {
        get<Retrofit>().create(LifeHackAPI::class.java)
    }

    single<CompaniesRepository> {
        CompaniesRemoteRepositoryImpl(source = get())
    }

    single<CompaniesRemoteSource> {
        CompaniesRemoteSource(api = get())
    }

    single<CompaniesInteractor> {
        CompaniesInteractor(repository = get())
    }

    viewModel {
        MainScreenViewModel(companiesInteractor = get())
    }

}