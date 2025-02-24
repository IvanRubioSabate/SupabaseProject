package com.example.supabase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supabase.R
import com.example.supabase.adapters.LlistarProductsAdapter
import com.example.supabase.data.models.Product
import com.example.supabase.databinding.FragmentLlistarProductesBinding
import com.example.supabase.databinding.FragmentLoginBinding
import com.example.supabase.viewModels.ProductsViewModel
import com.example.supabase.viewModels.SelectedProductViewModel
import kotlinx.coroutines.runBlocking

class LlistarProductesFragment : Fragment() {

    private lateinit var binding: FragmentLlistarProductesBinding
    private val productsViewModel: ProductsViewModel by activityViewModels<ProductsViewModel>()
    private val selectedProductViewModel: SelectedProductViewModel by activityViewModels<SelectedProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLlistarProductesBinding.inflate(inflater)

        runBlocking {
            productsViewModel.loadProductes()
        }

        productsViewModel.products.observe(viewLifecycleOwner, Observer { products ->
            actualitzarRecycler(products)
        })

        binding.productsRecycler.layoutManager = LinearLayoutManager(context)

        binding.afegirButton.setOnClickListener {
            findNavController().navigate(R.id.action_llistarProductesFragment_to_addProductFragment)
        }

        return binding.root
    }

    private fun actualitzarRecycler(llista: List<Product>?) {
        if (llista != null) binding.productsRecycler.adapter = LlistarProductsAdapter(llista, findNavController(), selectedProductViewModel)
        else binding.productsRecycler.adapter = LlistarProductsAdapter(listOf(), findNavController(), selectedProductViewModel)
    }
}