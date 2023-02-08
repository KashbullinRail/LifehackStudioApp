package com.example.lifehackstudioapp.main_screen.data

import com.example.lifehackstudioapp.main_screen.data.model.CompanyRemoteModel
import com.example.lifehackstudioapp.main_screen.domain.CompanyModel


fun CompanyRemoteModel.toDomain() = CompanyModel(
    id = id ?: "",
    name = name ?: "",
    image = img ?: ""
)