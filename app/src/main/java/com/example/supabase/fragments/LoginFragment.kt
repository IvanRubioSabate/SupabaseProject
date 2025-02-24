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
import com.example.supabase.databinding.FragmentLoginBinding
import com.example.supabase.viewModels.SignViewModel
import kotlinx.coroutines.runBlocking

class LoginFragment : Fragment() {

    private val signViewModel: SignViewModel by activityViewModels<SignViewModel>()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)

        binding.loginSignUpText.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.loginButton.setOnClickListener {
            runBlocking {
                login()
            }
        }

        return binding.root
    }

    private suspend fun login() {
        val email: String = binding.inputEmail.text.toString()
        val password: String = binding.inputPassword.text.toString()

        if (signViewModel.logIn(email, password)) {
            Toast.makeText(context, "User Logged In", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_loginFragment_to_llistarProductesFragment)
        } else {
            Toast.makeText(context, "User Could Not Be Logged In", Toast.LENGTH_SHORT).show()
        }
    }

}