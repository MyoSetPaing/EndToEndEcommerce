package com.myosetpaing.endtoend.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.endtoend.R
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.ProductItemDelegate
import com.myosetpaing.endtoend.views.holders.ProductViewHolder

class ProductRecyclerViewAdapter(var context: Context, private val delegate:ProductItemDelegate) :
    BaseRecyclerAdapter<ProductViewHolder, ProductVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ProductViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.item_view_product, parent, false)

        return ProductViewHolder(itemView,delegate)
    }


}