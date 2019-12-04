package com.sevenpeakssoftware.yogendra_b.model.room

import android.os.Parcelable
import androidx.room.Entity
import com.sevenpeakssoftware.yogendra_b.model.CarContent
import kotlinx.android.parcel.Parcelize
import java.util.*


/**
 * Each car object must consist of below params because we are
 * going to populate those on screen
 *
 * @param title
 * @param image
 * @param dateTime
 * @param ingress
 *
 * */

@Parcelize
@Entity(primaryKeys = [("id")])
data class Car(
    val id: Int,
    val title: String,
    val ingress: String,
    val image: String,
    val dateTime: String,
    val created: Int,
    val Changed: Int,
    var tags: List<String>?,
    var content: List<CarContent> = ArrayList()
):Parcelable