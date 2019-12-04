package com.sevenpeakssoftware.yogendra_b.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CarContent(
    val type: String,
    val subject: String,
    val description: String
) : Parcelable