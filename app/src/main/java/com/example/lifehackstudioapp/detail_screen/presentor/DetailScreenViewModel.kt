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
        processDataEvent(DateEvent.LoadCompanies)
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
            is DateEvent.LoadCompanies -> {
                viewModelScope.launch {
                    companyDetailInteractor.getCompanyDetail().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                            State.Error
                        },
                        onSuccess = {
                            processDataEvent(DateEvent.OnLoadCompaniesSucceed(it))
                        }
                    )
                }
                return null
            }
            is DateEvent.OnLoadCompaniesSucceed -> {
                return previousState.copy(

                    state = State.Content
                )
            }
            is UIEvent.OnCompanyClicked -> {
                return previousState.copy(

                )
            }

            else -> return null
        }

    }

}