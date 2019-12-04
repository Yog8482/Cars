package com.sevenpeakssoftware.yogendra_b.view.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.sevenpeakssoftware.yogendra_b.model.room.Car
import kotlinx.android.synthetic.main.item_car.view.*


class CarListViewHolder(
    val view: View
) : BaseViewHolder(view) {

    private lateinit var car: Car

    @Throws(Exception::class)
    override fun bindData(data: Any) {
        if (data is Car) {
            car = data
            drawItem()
        }
    }

    private fun drawItem() {
        itemView.run {
            car_title.text = car.title
            car_ingress.text = car.ingress
            car_date.text = car.dateTime
            car.image.let {
                Glide.with(context)
                    .load(it)
                    .into(item_image_car)
            }
        }
    }

}
