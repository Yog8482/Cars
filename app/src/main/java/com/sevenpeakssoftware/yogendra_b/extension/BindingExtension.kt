package com.sevenpeakssoftware.yogendra_b.extension


import android.view.View
import android.widget.Toast
import com.sevenpeakssoftware.yogendra_b.model.Resource
import com.sevenpeakssoftware.yogendra_b.model.Status

inline fun <reified T> View.bindResource(resource: Resource<T>?, onSuccess: (Resource<T>) -> Unit) {
  if (resource != null) {
    when (resource.status) {
      Status.LOADING -> Unit
      Status.SUCCESS -> onSuccess(resource)
      Status.ERROR -> Toast.makeText(this.context,resource.errorEnvelope?.status_message.toString(),Toast.LENGTH_LONG)
    }
  }
}
