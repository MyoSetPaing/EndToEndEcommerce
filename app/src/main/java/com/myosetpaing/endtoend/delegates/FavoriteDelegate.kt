package com.myosetpaing.endtoend.delegates

import com.myosetpaing.endtoend.data.vos.ProductVO

interface FavoriteDelegate {

    fun onSuccesGettingFavoriteProduct(productList:List<ProductVO>)
    fun onFailGettingFavoriteProduct(message:String)

}