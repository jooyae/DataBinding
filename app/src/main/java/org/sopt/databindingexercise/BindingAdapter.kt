package org.sopt.databindingexercise

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import retrofit2.http.Url

@BindingAdapter("uploadImage")
fun uploadImage(view:ImageView, resource: String){
    Glide.with(view.context)
        .load(resource)
        .into(view)
}