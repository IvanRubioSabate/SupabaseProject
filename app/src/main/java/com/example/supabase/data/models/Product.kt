package com.example.supabase.data.models

import java.util.UUID

data class Product(
    val id: Int,
    val user_id: UUID,
    val name: String,
    val price: Float
)
