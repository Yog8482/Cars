package com.sevenpeakssoftware.yogendra_b.view.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/** BaseViewHolder is an abstract class for structuring the base view holder class. */
abstract class BaseViewHolder(private val view: View)
    : RecyclerView.ViewHolder(view){

    /** binds data to the view holder class. */
    @Throws(Exception::class)
    abstract fun bindData(data: Any)

    /** gets the view of the [RecyclerView.ViewHolder]. */
    fun view(): View {
        return view
    }

    /** gets the context. */
    fun context(): Context {
        return view.context
    }
}
