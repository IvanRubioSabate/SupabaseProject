package com.example.supabase.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.supabase.data.models.Product
import com.example.supabase.data.repositoris.SupabaseRepositori

class ProductsViewModel: ViewModel() {

    private var _products: MutableLiveData<List<Product>> = MutableLiveData()
    val products : LiveData<List<Product>>
        get() = _products

    suspend fun loadProductes() {
        _products.value = SupabaseRepositori.getProducts()
        Log.i("PRODUCTES", SupabaseRepositori.getProducts().toString())
    }
}