package com.example.mvvm_countries.util

import android.content.*
import android.widget.*
import androidx.core.content.*
import androidx.swiperefreshlayout.widget.*
import com.bumptech.glide.*

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        setColorSchemeColors(ContextCompat.getColor(context, com.example.mvvm_countries.R.color.white))
        start()
    }
}
fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable) {
    Glide.with(context)
        .load(uri)
        .placeholder(progressDrawable) // Directly set placeholder
        .error(com.example.mvvm_countries.R.mipmap.ic_launcher_round) // Corrected to drawable
        .into(this)
}