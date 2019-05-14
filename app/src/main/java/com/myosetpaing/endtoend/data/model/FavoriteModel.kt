package com.myosetpaing.endtoend.data.model

import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.FavoriteDelegate

interface FavoriteModel {
    fun getFavoriteProduct(delegate: FavoriteDelegate)
    fun addToFavorite(product: ProductVO): Long
    fun removeFromFavorite(productId: Int)

    fun isFavorite(productId: Int): Boolean
}