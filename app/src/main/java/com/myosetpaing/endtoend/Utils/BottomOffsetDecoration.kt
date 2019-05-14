package com.myosetpaing.endtoend.Utils

import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class BottomOffsetDecoration(var bottomOffset: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val dataSize = state.itemCount
        val position = parent.getChildAdapterPosition(view)
        if (parent.layoutManager is GridLayoutManager) {
            val grid = parent.layoutManager as GridLayoutManager
            val spanCount = 2 //grid.spanCount
            if (dataSize - position < spanCount) {
                outRect.set(0, 0, 0, bottomOffset)
            } else {
                outRect.set(0, 0, 0, 0)
            }
        } else {
            if (dataSize > 0 && position == dataSize - 1) {
                outRect.set(0, 0, 0, bottomOffset)
            } else {
                outRect.set(0, 0, 0, 0)
            }
        }
    }
}