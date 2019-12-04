package com.sevenpeakssoftware.yogendra_b.binding

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.sevenpeakssoftware.yogendra_b.extension.bindResource
import com.sevenpeakssoftware.yogendra_b.extension.getParentActivity
import com.sevenpeakssoftware.yogendra_b.model.Resource
import com.sevenpeakssoftware.yogendra_b.model.room.Car
import com.sevenpeakssoftware.yogendra_b.view.adapter.CarListAdapter


@BindingAdapter("adapterCarList")
fun bindAdapterCarList(view: RecyclerView, resource: Resource<List<Car>>?) {
  view.bindResource(resource) {
    val adapter = view.adapter as? CarListAdapter
    adapter?.addCarList(it)
  }
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
  val parentActivity: AppCompatActivity? = view.getParentActivity()
  if(parentActivity != null && visibility != null) {
    visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
  }
}