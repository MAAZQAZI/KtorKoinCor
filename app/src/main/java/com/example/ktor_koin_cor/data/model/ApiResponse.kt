package com.example.ktor_koin_cor.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class ApiResponse(
    @SerialName("data")
    val `data`: Data?,
    @SerialName("support")
    val support: Support?
) {
    @Serializable
    data class Data(
        @SerialName("avatar")
        val avatar: String?,
        @SerialName("email")
        val email: String?,
        @SerialName("first_name")
        val firstName: String?,
        @SerialName("id")
        val id: Int?,
        @SerialName("last_name")
        val lastName: String?
    )

    @Serializable
    data class Support(
        @SerialName("text")
        val text: String?,
        @SerialName("url")
        val url: String?
    )
}