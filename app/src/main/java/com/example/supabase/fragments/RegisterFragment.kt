package com.example.supabase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.supabase.R
import com.example.supabase.databinding.FragmentRegisterBinding
import com.example.supabase.viewModels.SignViewModel
import kotlinx.coroutines.runBlocking

class RegisterFragment : Fragment() {

    private val signViewModel: SignViewModel by activityViewModels<SignViewModel>()
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater)

        binding.registerSignInText.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        binding.registerButton.setOnClickListener {
            runBlocking {
                register()
            }
        }

        return binding.root
    }

    private suspend fun register() {
        val email: String = binding.inputEmail.text.toString()
        val password: String = binding.inputPassword.text.toString()

        if(signViewModel.registerUser(email, password)) {
            Toast.makeText(context, "User Registered, please veify your email", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "User Could Not Be Registered", Toast.LENGTH_SHORT).show()
        }
    }
}