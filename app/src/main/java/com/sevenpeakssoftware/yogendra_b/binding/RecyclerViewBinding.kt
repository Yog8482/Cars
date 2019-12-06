package com.sevenpeakssoftware.yogendra_b.binding

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sevenpeakssoftware.yogendra_b.R
import com.sevenpeakssoftware.yogendra_b.extension.bindResource
import com.sevenpeakssoftware.yogendra_b.extension.getParentActivity
import com.sevenpeakssoftware.yogendra_b.model.Resource
import com.sevenpeakssoftware.yogendra_b.model.Status
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
fun setMutableVisibility(view: View, resource: Resource<List<Car>>?) {
    view.bindResource(resource) {
        when (resource?.status?.equals(Status.LOADING)) {
            true -> view.visibility = View.VISIBLE
            false -> view.visibility = View.GONE

        }


    }

}

@BindingAdapter("mutableRefreshing")
fun setmutableRefreshing(view: SwipeRefreshLayout, resource: Resource<List<Car>>?) {
    view.bindResource(resource) {
        when (resource?.status?.equals(Status.LOADING)) {
            true -> view.isRefreshing = true
            false -> view.isRefreshing = false

        }

    }
}
