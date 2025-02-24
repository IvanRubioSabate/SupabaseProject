package com.example.supabase.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.supabase.R
import com.example.supabase.data.models.Product
import com.example.supabase.databinding.FragmentEditProductBinding
import com.example.supabase.viewModels.EditProductViewModel
import com.example.supabase.viewModels.SelectedProductViewModel
import kotlinx.coroutines.runBlocking

class EditProductFragment : Fragment() {

    private lateinit var binding: FragmentEditProductBinding
    private val viewModel: EditProductViewModel by viewModels<EditProductViewModel>()
    private val selectedProductViewModel: SelectedProductViewModel by activityViewModels<SelectedProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEditProductBinding.inflate(inflater)

        actualitzarInputs(selectedProductViewModel.product)

        binding.updateButton.setOnClickListener {
            runBlocking {
                try {
                    viewModel.updateProduct(
                        id = selectedProductViewModel.product.id!!,
                        name = binding.inputNom.text.toString(),
                        price = binding.inputPreu.text.toString().toFloat()
                    )
                    Toast.makeText(context, "Product updated successfully", Toast.LENGTH_SHORT).show()
                } catch (error: Exception) {
                    Toast.makeText(context, "Product could not be updated", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.deleteButton.setOnClickListener {
            runBlocking {
                try {
                    viewModel.deleteProduct(selectedProductViewModel.product.id!!)
                    Toast.makeText(context, "Product deleted successfully", Toast.LENGTH_SHORT).show()
                    parentFragmentManager.popBackStack()
                } catch (error: Exception) {
                    Toast.makeText(context, "Product could not be deleted", Toast.LENGTH_SHORT).show()
                }
            }

        }

        return binding.root
    }

    fun actualitzarInputs(product: Product) {
        Log.d("PRODUCTNAME", product.name)
        Log.d("PRODUCTPRICE", product.price.toString())
        binding.inputNom.setText(product.name)
        binding.inputPreu.setText(product.price.toString())
    }
}