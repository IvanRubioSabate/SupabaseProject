package com.example.supabase.viewModels

import androidx.lifecycle.ViewModel
import com.example.supabase.data.repositoris.SupabaseRepositori

class ProductsViewModel: ViewModel() {

    suspend fun loadProductes() {
        val productes = SupabaseRepositori.getProducts()
    }
}