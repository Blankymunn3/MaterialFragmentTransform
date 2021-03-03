package com.blankymunn3.materialfragmenttransform.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("img_drawable")
fun imgDrawable(imageView: ImageView, drawable: Int) =
    Glide.with(imageView)
        .load(drawable)
        .into(imageView)