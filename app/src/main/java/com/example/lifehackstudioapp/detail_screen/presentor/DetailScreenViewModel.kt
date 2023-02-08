package com.example.lifehackstudioapp.detail_screen.presentor

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.lifehackstudioapp.base.BaseViewModel
import com.example.lifehackstudioapp.base.Event
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailInteractor
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailModel
import kotlinx.coroutines.launch


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
            "", "", "", ""
        )
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is UIEvent.OnDetailCompanyGet -> {
                return previousState.copy(
                    companyDetail = event.detailCompany
                )
            }
            is DateEvent.LoadCompanyDetail -> {
                viewModelScope.launch {
                    companyDetailInteractor.getCompanyDetail(previousState.companyDetail.id).fold(
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
                    companyDetail = event.companyShown,
                    state = State.Content
                )
            }


            else -> return null
        }

    }

}