package com.example.lifehackstudioapp.detail_screen.presentor

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.lifehackstudioapp.base.BaseViewModel
import com.example.lifehackstudioapp.base.Event
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailInteractor
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailModel
import kotlinx.coroutines.launch


const val REGEX_PHONE = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}\$"


class DetailScreenViewModel(
    private val companyDetailInteractor: CompanyDetailInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadCompanyDetail)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        companyDetail = CompanyDetailModel(
            "", "", "", "",
            0.0, 0.0, "", ""
        ),
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadCompanyDetail -> {
                viewModelScope.launch {
                    companyDetailInteractor.getCompanyDetail().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                            State.Error
                        },
                        onSuccess = {
                            processDataEvent(DateEvent.OnLoadCompanyDetailSucceed(it))
                        }
                    )
                }
                return null
            }
            is DateEvent.OnLoadCompanyDetailSucceed -> {
                return previousState.copy(
                    companyDetail = event.companyShown.first(),
                    state = State.Content
                )
            }
            is UIEvent.OnPhoneClicked -> {
                return previousState.copy(
                    state = State.PhoneCallOpen
                )
            }
            is UIEvent.OnWebsiteClicked -> {
                    return previousState.copy(
                        state = State.WebsiteOpen
                    )
            }

            else -> return null
        }

    }

}