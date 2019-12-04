package com.sevenpeakssoftware.yogendra_b.model

import com.sevenpeakssoftware.yogendra_b.model.room.Car

data class CarApiResponse(
    val status: String,
    val content: List<Car>,
    val serverTime: String
) : NetworkResponseModel