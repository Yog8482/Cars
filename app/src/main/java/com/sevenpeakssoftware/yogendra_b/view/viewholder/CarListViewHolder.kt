package com.sevenpeakssoftware.yogendra_b.view.viewholder

import android.annotation.SuppressLint
import android.text.format.DateFormat
import android.view.View
import com.bumptech.glide.Glide
import com.sevenpeakssoftware.yogendra_b.model.room.Car
import kotlinx.android.synthetic.main.item_car.view.*
import java.text.SimpleDateFormat
import java.util.*


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
            car_date.text = getFormattedDateTime(car.dateTime)

            car.image.let {
                Glide.with(context)
                    .load(it)
                    .into(item_image_car)
            }
        }
    }


    @SuppressLint("SimpleDateFormat")
    private fun getFormattedDateTime(dateTime: String): String {
        val postFormater: Any
        var newDateStr: String = dateTime
        val curFormater = SimpleDateFormat("dd.MM.yyyy HH:MM")
        val dateObj: Date = curFormater.parse(dateTime)

        val calendar = Calendar.getInstance()
        val currentyear: Int = calendar.get(Calendar.YEAR)

        calendar.time = dateObj
        val year: Int = calendar.get(Calendar.YEAR)

        when (currentyear == year) {
            true -> {
                if (DateFormat.is24HourFormat(this.context()))
                    postFormater = SimpleDateFormat("dd MMMM, HH:MM")
                else
                    postFormater = SimpleDateFormat("dd MMMM, hh:MM a")

                newDateStr = postFormater.format(dateObj)

            }
            false
            -> {
                if (DateFormat.is24HourFormat(this.context()))
                    postFormater = SimpleDateFormat("dd MMMM yyyy, HH:MM")
                else
                    postFormater = SimpleDateFormat("dd MMMM yyyy, hh:MM a")

                newDateStr = postFormater.format(dateObj)
            }

        }
        return newDateStr

    }
}
