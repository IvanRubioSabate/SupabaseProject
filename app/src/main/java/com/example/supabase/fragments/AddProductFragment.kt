package com.example.supabase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import co.touchlab.kermit.Logger
import com.example.supabase.R
import com.example.supabase.data.models.Product
import com.example.supabase.databinding.FragmentAddProductBinding
import com.example.supabase.viewModels.AddProductViewModel
import kotlinx.coroutines.runBlocking

class AddProductFragment : Fragment() {

    private lateinit var binding: FragmentAddProductBinding
    private val viewModel: AddProductViewModel by viewModels<AddProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddProductBinding.inflate(inflater)

        binding.insertButton.setOnClickListener {
            runBlocking {
                try {
                    viewModel.addProduct(
                        Product(
                            name = binding.inputNom.text.toString(),
                            price = binding.inputPreu.text.toString().toFloat()
                        )
                    )
                    Toast.makeText(context, "Product added correctly", Toast.LENGTH_SHORT).show()
                } catch (error: Exception) {
                    Toast.makeText(context, "Product could not be added", Toast.LENGTH_SHORT).show()
                }
            }

        }

        return binding.root
    }

}