package com.example.lifehackstudioapp.detail_screen.presentor

import com.example.lifehackstudioapp.base.Event
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailModel


enum class State {
    Load,
    Content,
    WebsiteOpen,
    PhoneCallOpen,
    Error
}

data class ViewState(
    val state: State,
    val companyDetail: CompanyDetailModel
)

sealed class UIEvent : Event {
    object OnCompanyClicked : UIEvent()
}

sealed class DateEvent : Event {
    object LoadCompanies : DateEvent()
    data class OnLoadCompaniesSucceed(val company: CompanyDetailModel) : DateEvent()
}