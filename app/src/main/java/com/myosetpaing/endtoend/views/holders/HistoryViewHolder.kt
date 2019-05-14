package com.myosetpaing.endtoend.views.holders

import android.view.TouchDelegate
import android.view.View
import com.bumptech.glide.Glide
import com.myosetpaing.endtoend.data.vos.FavoriteVO
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.ProductDelegate
import com.myosetpaing.endtoend.delegates.ProductItemDelegate
import kotlinx.android.synthetic.main.view_item_favorite.view.*

class HistoryViewHolder(itemView: View, private val delegate: ProductItemDelegate) : BaseViewHolder<ProductVO>(itemView) {


    override fun setData(data: ProductVO) {

        Glide.with(itemView.context)
            .load(data.product_image_url?.get(0)?.image_url)
            .into(itemView.ivFavoriteImage)

        itemView.setOnClickListener {

        }

    }

    override fun onClick(v: View?) {
    }

}