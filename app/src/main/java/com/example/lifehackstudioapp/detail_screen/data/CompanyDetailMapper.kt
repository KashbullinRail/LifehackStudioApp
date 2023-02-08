package com.example.lifehackstudioapp.detail_screen.data

import com.example.lifehackstudioapp.detail_screen.data.model.CompanyDetailRemoteModel
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailModel


fun CompanyDetailRemoteModel.toDomain() = CompanyDetailModel(
    id = id ?: "",
    name = name ?: "",
    image = img ?: "",
    description = description?:"",
    latitude = lon ?: 0.0,
    longitude = lon ?: 0.0,
    websiteAddress = www?:"",
    phoneNumber = phone?:""
)