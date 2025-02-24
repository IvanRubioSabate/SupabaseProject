package com.example.supabase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.supabase.R
import com.example.supabase.data.models.Product
import com.example.supabase.viewModels.SelectedProductViewModel

class LlistarProductsAdapter(private val mList: List<Product>, private val navController: NavController, private val viewModel: SelectedProductViewModel): RecyclerView.Adapter<LlistarProductsAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.llistat_products_card_view, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = mList[position]

        holder.textViewNom.text = product.name
        holder.textViewPreu.text = product.price.toString() + "€"

        holder.productLayout.setOnClickListener {
            viewModel.selectProduct(product)
            navController.navigate(R.id.action_llistarProductesFragment_to_editProductFragment)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewNom: TextView = itemView.findViewById(R.id.productName)
        val textViewPreu: TextView = itemView.findViewById(R.id.productPrice)
        val productLayout: ConstraintLayout = itemView.findViewById(R.id.productLayout)
    }
}