package com.example.supabase.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int? = null,
    val name: String,
    val price: Float
)
