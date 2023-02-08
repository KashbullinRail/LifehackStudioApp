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
    data class OnDetailCompanyGet(val detailCompany: CompanyDetailModel) : UIEvent()
    object OnWebsiteClicked : UIEvent()
    object OnPhoneClicked : UIEvent()
}

sealed class DateEvent : Event {
    object LoadCompanyDetail : DateEvent()
    data class OnLoadCompanyDetailSucceed(val companyShown: CompanyDetailModel) : DateEvent()
}