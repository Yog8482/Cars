package com.sevenpeakssoftware.yogendra_b.view.adapter

import android.view.View
import com.sevenpeakssoftware.yogendra_b.R
import com.sevenpeakssoftware.yogendra_b.model.Resource
import com.sevenpeakssoftware.yogendra_b.model.SectionRow
import com.sevenpeakssoftware.yogendra_b.model.room.Car
import com.sevenpeakssoftware.yogendra_b.view.viewholder.CarListViewHolder

class CarListAdapter(): BaseAdapter() {

    init {
        addSection(ArrayList<Car>())
    }

    fun addCarList(resource: Resource<List<Car>>) {
        resource.data?.let {
            sections()[0].addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_car

    override fun viewHolder(layout: Int, view: View) = CarListViewHolder(view)

}