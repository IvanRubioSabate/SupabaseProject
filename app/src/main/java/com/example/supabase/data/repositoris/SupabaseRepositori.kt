package com.example.supabase.data.repositoris

import android.util.Log
import com.example.supabase.data.models.Product
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from

class SupabaseRepositori {
    companion object {
        private val supabase = createSupabaseClient(
            supabaseUrl = "https://hamqgepjixbvqajtgcbu.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImhhbXFnZXBqaXhidnFhanRnY2J1Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzkxODkxNDcsImV4cCI6MjA1NDc2NTE0N30.hcnZwtTG_8eMeIKEtnDBMYDuiHxtrqfw408gU1E3wQY"
        ) {
            install(Auth)
            install(Postgrest)
            //install other modules
        }

        suspend fun createUser(mail: String, passwd: String) {
            supabase.auth.signUpWith(Email) {
                email = mail
                password = passwd
            }
        }

        suspend fun logIn(mail: String, passwd: String) {
            supabase.auth.signInWith(Email) {
                email = mail
                password = passwd
            }

            val userInfo: UserInfo? = supabase.auth.currentUserOrNull()

            Log.i("user", userInfo.toString())
        }

        suspend fun getProducts(): List<Product> {
            val products = supabase.from("product").select().decodeList<Product>()
            Log.i("PRODUCTS", products.toString())
            return products
        }
    }
}