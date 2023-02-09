package com.example.lifehackstudioapp.detail_screen.presentor

import com.example.lifehackstudioapp.base.Event
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailModel


enum class State {
    Load,
    Content,
    WebsiteOpen,
    PhoneCallOpen,
    MapCoordinate,
    Error
}

data class ViewState(
    val state: State,
    val companyDetail: CompanyDetailModel,
)

sealed class UIEvent : Event {
    object OnWebsiteClicked : UIEvent()
    object OnPhoneClicked : UIEvent()
    object OnMapCoordinate : UIEvent()
}

sealed class DateEvent : Event {
    object LoadCompanyDetail : DateEvent()
    data class OnLoadCompanyDetailSucceed(val companyShown: List<CompanyDetailModel>) : DateEvent()
}