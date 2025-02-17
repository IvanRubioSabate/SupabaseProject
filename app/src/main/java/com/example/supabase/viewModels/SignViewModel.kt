package com.example.supabase.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.supabase.data.repositoris.SupabaseRepositori

class SignViewModel: ViewModel() {
    suspend fun registerUser(mail: String, passwd: String): Boolean {
        try {
            SupabaseRepositori.createUser(mail, passwd)
            return true
        } catch (e: Exception) {
            Log.e("ERROR", e.message.toString())
            return false
        }
    }

    suspend fun logIn(mail: String, passwd: String): Boolean {
        try {
            SupabaseRepositori.logIn(mail, passwd)
            return true
        } catch (e: Exception) {
            Log.e("ERROR", e.message.toString())
            return false
        }
    }
}