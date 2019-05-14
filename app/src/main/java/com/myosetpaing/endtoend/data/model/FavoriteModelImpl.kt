package com.myosetpaing.endtoend.data.model

import com.myosetpaing.endtoend.data.vos.FavoriteVO
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.FavoriteDelegate

object FavoriteModelImpl : BaseModel(), FavoriteModel {

    override fun getFavoriteProduct(delegate: FavoriteDelegate) {
        val favoriteProducts = mDatabase.favouriteDao().retrieveFavoriteProducts()
        if (favoriteProducts.isEmpty()) {
            delegate.onFailGettingFavoriteProduct("")
        } else {
            delegate.onSuccesGettingFavoriteProduct(favoriteProducts)
        }
    }

    override fun addToFavorite(product: ProductVO): Long {
        val favoriteProduct = FavoriteVO(
            productId = product.product_id,
            productName = product.product_name!!,
            productPrice = product.product_price!!,
            productImageUrls = product.product_image_url!!
        )

        val addItem = mDatabase.favouriteDao().addFavoriteProduct(favoriteProduct)

        return addItem
    }

    override fun removeFromFavorite(productId: Int){

        mDatabase.favouriteDao().removeFavoriteProducts(productId)
    }
    override fun isFavorite(productId: Int): Boolean {
        return mDatabase.isFavorite(productId)
    }


}
