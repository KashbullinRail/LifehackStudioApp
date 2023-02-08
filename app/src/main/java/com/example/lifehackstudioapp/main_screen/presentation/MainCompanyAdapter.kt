package com.example.lifehackstudioapp.main_screen.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.lifehackstudioapp.R
import com.example.lifehackstudioapp.databinding.ItemCompanyAdapterBinding
import com.example.lifehackstudioapp.main_screen.domain.CompanyModel


const val URL_IMAGE = "https://lifehack.studio/test_task/"


class MainCompanyAdapter(
    val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<MainCompanyAdapter.MainCompanyViewHolder>() {

    class MainCompanyViewHolder(
        val binding: ItemCompanyAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root)

    var companies: List<CompanyModel> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = companies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCompanyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCompanyAdapterBinding.inflate(inflater, parent, false)
        return MainCompanyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainCompanyViewHolder, position: Int) {

        //handle pressing the open detail item
        holder.itemView.setOnClickListener {
            onItemClicked.invoke(position)
        }

        val company = companies[position]
        with(holder.binding) {
            //setting variables
            holder.itemView.tag = company
            tvNameCompany.text = company.name

            Glide
                .with(ivCompany.context)
                .load(URL_IMAGE + company.image)
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_image_not_supported)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .centerCrop()
                .into(ivCompany)
        }

    }

    //redrawing UI
    @SuppressLint("NotifyDataSetChanged")
    fun setData(companies: List<CompanyModel>) {
        this.companies = companies
        notifyDataSetChanged()
    }

}