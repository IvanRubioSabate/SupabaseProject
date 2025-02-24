package com.example.supabase.viewModels

import androidx.lifecycle.ViewModel
import com.example.supabase.data.repositoris.SupabaseRepositori

class EditProductViewModel: ViewModel() {
    suspend fun updateProduct(id: Int, name: String, price: Float) {
        SupabaseRepositori.updateProduct(id, name, price)
    }

    suspend fun deleteProduct(id: Int) {
        SupabaseRepositori.deleteProduct(id)
    }
}