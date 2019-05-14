package com.myosetpaing.endtoend.delegates

import com.myosetpaing.endtoend.data.vos.ProductVO

interface ProductItemDelegate {
    fun onTapProductItem(product: ProductVO)
    fun onTapFavorite(product: ProductVO)
}