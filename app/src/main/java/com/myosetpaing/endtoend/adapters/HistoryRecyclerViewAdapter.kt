package com.myosetpaing.endtoend.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.endtoend.R
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.ProductItemDelegate
import com.myosetpaing.endtoend.views.holders.HistoryViewHolder

class HistoryRecyclerViewAdapter(var context: Context, private val delegate: ProductItemDelegate) :
    BaseRecyclerAdapter<HistoryViewHolder, ProductVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.view_item_favorite, parent, false)

        return HistoryViewHolder(itemView, delegate)
    }
}