package com.myosetpaing.endtoend.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.endtoend.R
import com.myosetpaing.endtoend.data.vos.CategoryVO
import com.myosetpaing.endtoend.delegates.CategoryItemDelegate
import com.myosetpaing.endtoend.views.holders.CategoryViewHolder

class CategoryRecyclerViewAdapter(val context: Context,private val mDelegate: CategoryItemDelegate): BaseRecyclerAdapter<CategoryViewHolder,CategoryVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_view_category, parent, false)

        return CategoryViewHolder(itemView,mDelegate)
    }

}