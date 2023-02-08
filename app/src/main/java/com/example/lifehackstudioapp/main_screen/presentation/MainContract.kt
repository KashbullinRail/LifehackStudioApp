package com.example.lifehackstudioapp.main_screen.presentation

import com.example.lifehackstudioapp.base.Event
import com.example.lifehackstudioapp.main_screen.domain.CompanyModel


enum class State {
    Load,
    Content,
    DetailLoad,
    Error
}

data class ViewState(
    val state: State,
    val companyShown: List<CompanyModel>,
    val companiesList: List<CompanyModel>,
    val companyDetail: CompanyModel
)

sealed class UIEvent : Event {
    data class OnCompanyClicked(val index: Int, val type: String) : UIEvent()
}

sealed class DateEvent : Event {
    object LoadCompanies : DateEvent()
    data class OnLoadCompaniesSucceed(val companies: List<CompanyModel>) : DateEvent()
}