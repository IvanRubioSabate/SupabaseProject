package com.example.supabase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supabase.R
import com.example.supabase.databinding.FragmentLlistarProductesBinding
import com.example.supabase.databinding.FragmentLoginBinding
import com.example.supabase.viewModels.ProductsViewModel

class LlistarProductesFragment : Fragment() {

    private lateinit var binding: FragmentLlistarProductesBinding
    private val productsViewModel: ProductsViewModel by activityViewModels<ProductsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLlistarProductesBinding.inflate(inflater)



        binding.moblesRecycler.layoutManager = LinearLayoutManager(context)

        return binding.root
    }
}