package com.example.lifehackstudioapp.main_screen.data

import com.example.lifehackstudioapp.main_screen.data.model.CompanyRemoteModel
import com.example.lifehackstudioapp.main_screen.domain.CompaniesModel


fun CompanyRemoteModel.toDomain() = CompaniesModel(
    id = id ?: "",
    name = name ?: "",
    image = img ?: ""
)