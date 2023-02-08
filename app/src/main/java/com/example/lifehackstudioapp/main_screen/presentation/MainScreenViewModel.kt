package com.example.lifehackstudioapp.main_screen.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.lifehackstudioapp.base.BaseViewModel
import com.example.lifehackstudioapp.base.Event
import com.example.lifehackstudioapp.main_screen.domain.CompaniesInteractor
import com.example.lifehackstudioapp.main_screen.domain.CompanyModel
import kotlinx.coroutines.launch


class MainScreenViewModel(
    private val companiesInteractor: CompaniesInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadCompanies)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        companiesList = emptyList(),
        companyShown = emptyList(),
        companyDetail = CompanyModel("", "", "")
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadCompanies -> {
                viewModelScope.launch {
                    companiesInteractor.getCompaniesList().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
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
                    companiesList = event.companies,
                    companyShown = event.companies,
                    state = State.Content
                )
            }

            else -> return null
        }

    }

}