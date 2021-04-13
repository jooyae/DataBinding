package org.sopt.databindingexercise

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("uploadImage")
fun uploadImage(view:ImageView, resource:Drawable){
    Glide.with(view.context).load(resource).into(view)
}