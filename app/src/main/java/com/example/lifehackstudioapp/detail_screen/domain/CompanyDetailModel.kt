package com.example.lifehackstudioapp.detail_screen.domain

data class CompanyDetailModel(
    val id: String,
    val name: String,
    val image: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val websiteAddress: String,
    val phoneNumber: String
)
