package com.example.lifehackstudioapp.detail_screen.di

import com.example.lifehackstudioapp.detail_screen.data.CompanyDetailAPI
import com.example.lifehackstudioapp.detail_screen.data.CompanyDetailRemoteSource
import com.example.lifehackstudioapp.detail_screen.data.model.CompanyDetailRemoteRepositoryImpl
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailInteractor
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailRepository
import com.example.lifehackstudioapp.detail_screen.presentor.DetailScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val detailScreenModule = module {

    single<CompanyDetailAPI> {
        get<Retrofit>().create(CompanyDetailAPI::class.java)
    }

    single<CompanyDetailRepository> {
        CompanyDetailRemoteRepositoryImpl(source = get())
    }

    single<CompanyDetailRemoteSource> {
        CompanyDetailRemoteSource(api = get())
    }

    single<CompanyDetailInteractor> {
        CompanyDetailInteractor(repository = get())
    }

    viewModel {
        DetailScreenViewModel(companyDetailInteractor = get())
    }

}