package com.example.supabase.viewModels

import androidx.lifecycle.ViewModel
import com.example.supabase.data.models.Product
import com.example.supabase.data.repositoris.SupabaseRepositori

class AddProductViewModel: ViewModel() {
    suspend fun addProduct(product: Product) {
        SupabaseRepositori.insertProduct(product)
    }
}