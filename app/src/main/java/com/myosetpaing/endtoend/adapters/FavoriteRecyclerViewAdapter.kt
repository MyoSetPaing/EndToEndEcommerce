package com.myosetpaing.endtoend.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.endtoend.R
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.ProductDelegate
import com.myosetpaing.endtoend.delegates.ProductItemDelegate
import com.myosetpaing.endtoend.views.holders.FavoriteViewHolder

class FavoriteRecyclerViewAdapter(var context: Context,private val delegate:ProductItemDelegate) : BaseRecyclerAdapter<FavoriteViewHolder, ProductVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.view_item_favorite, parent, false)

        return FavoriteViewHolder(itemView,delegate)
    }
}