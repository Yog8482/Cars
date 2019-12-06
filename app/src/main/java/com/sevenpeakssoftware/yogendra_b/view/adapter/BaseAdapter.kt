package com.sevenpeakssoftware.yogendra_b.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView
import com.sevenpeakssoftware.yogendra_b.model.SectionRow
import com.sevenpeakssoftware.yogendra_b.view.viewholder.BaseViewHolder


/** BaseAdapter is an abstract class for structuring the base adapter class. */
abstract class BaseAdapter :
    RecyclerView.Adapter<BaseViewHolder>(), LifecycleObserver {
    /** data holding list attribute. */
    private val sections = ArrayList<MutableList<Any>>()

    /** gets mutable section list. */
    fun sections(): MutableList<MutableList<Any>> {
        return sections
    }

    /** adds a section on the section list. */
    fun <T> addSection(section: List<T>) {
        sections().add(ArrayList<Any>(section))
    }

    /** clears all sections. */
    fun clearAllSections() {
        sections().clear()
    }

    /** returns layout resources by section rows. */
    protected abstract fun layout(sectionRow: SectionRow): Int

    /** returns [RecyclerView.ViewHolder] by layouts. */
    protected abstract fun viewHolder(@LayoutRes layout: Int, view: View): BaseViewHolder

    override fun onViewDetachedFromWindow(holder: BaseViewHolder) {
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder) {
        super.onViewAttachedToWindow(holder)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, @LayoutRes layout: Int): BaseViewHolder {
        val view = inflateView(viewGroup, layout)
        return viewHolder(layout, view)
    }

    override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
        val data = objectFromPosition(position)

        try {
            viewHolder.bindData(data)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return layout(sectionRowFromPosition(position))
    }

    /** gets all item counts on the sections. */
    override fun getItemCount(): Int {
        var itemCount = 0
        for (section in sections) {
            itemCount += section.size
        }
        return itemCount
    }

    protected fun objectFromSectionRow(sectionRow: SectionRow): Any {
        return sections[sectionRow.section][sectionRow.row]
    }

    protected fun objectFromPosition(position: Int): Any {
        return objectFromSectionRow(sectionRowFromPosition(position))
    }

    private fun sectionRowFromPosition(position: Int): SectionRow {
        val sectionRow = SectionRow()
        var cursor = 0
        for (section in sections) {
            for (item in section) {
                if (cursor == position) {
                    return sectionRow
                }
                cursor++
                sectionRow.nextRow()
            }
            sectionRow.nextSection()
        }

        throw RuntimeException("Position $position not found in sections")
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun onDestroyed() {
        this.clearAllSections()
    }
}