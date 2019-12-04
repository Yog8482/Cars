package com.sevenpeakssoftware.yogendra_b.model

data class ErrorEnvelope(
  val status_code: Int,
  val status_message: String,
  val success: Boolean
)
