package com.example.mvvm_countries.view

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_countries.data.*
import com.example.mvvm_countries.databinding.*
import com.example.mvvm_countries.util.*

class CountryListAdapter(var countries: ArrayList<Country>) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.name.text = countries[position].countryName
        holder.binding.capital.text = countries[position].capital
        holder.binding.imageView.loadImage(countries[position].flag, holder.progressDrawable)

    }

    class CountryViewHolder(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root){
        // Define the progressDrawable here
        val progressDrawable = getProgressDrawable(binding.root.context)
    }

}