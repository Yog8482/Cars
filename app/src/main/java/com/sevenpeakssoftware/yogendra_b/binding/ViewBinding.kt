package com.sevenpeakssoftware.yogendra_b.binding


import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sevenpeakssoftware.yogendra_b.extension.bindResource
import com.sevenpeakssoftware.yogendra_b.extension.visible
import com.sevenpeakssoftware.yogendra_b.model.Resource
import com.sevenpeakssoftware.yogendra_b.model.room.Car


@BindingAdapter("visibilityByResource")
fun bindVisibilityByResource(view: View, resource: Resource<List<Any>>?) {
    view.bindResource(resource) {
        it.data?.let {
            view.visible()
        }
    }
}

