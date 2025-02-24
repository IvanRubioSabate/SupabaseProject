package com.example.supabase.viewModels

import androidx.lifecycle.ViewModel
import com.example.supabase.data.models.Product

class SelectedProductViewModel: ViewModel() {
    private var _product: Product = Product(0, "", 0f)
    val product: Product
        get() = _product

    fun selectProduct(product: Product) {
        _product = product
    }
}