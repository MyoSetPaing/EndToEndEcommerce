package com.myosetpaing.endtoend.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.ProductItemDelegate
import kotlinx.android.synthetic.main.item_view_product.view.*

class ProductViewHolder(itemView: View, private val productItemDelegate: ProductItemDelegate) :
    BaseViewHolder<ProductVO>(itemView) {

    override fun setData(data: ProductVO) {
        Glide.with(itemView.context)
            .load(data.product_image_url?.get(0)?.image_url)
            .into(itemView.iv_product_image)

        itemView.tv_product_name.text = data.product_name
        itemView.tv_product_price.text = data.product_price
        itemView.setOnClickListener {
            productItemDelegate.onTapProductItem(data)
        }

    }

    override fun onClick(v: View?) {

    }
}