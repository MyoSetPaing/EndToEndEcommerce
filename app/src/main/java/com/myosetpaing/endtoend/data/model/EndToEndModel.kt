package com.myosetpaing.endtoend.data.model

import com.myosetpaing.endtoend.data.vos.CategoryVO
import com.myosetpaing.endtoend.delegates.CategoryDelegate
import com.myosetpaing.endtoend.delegates.ProductDelegate
import com.myosetpaing.endtoend.delegates.ProductDetailDelegate

interface EndToEndModel {


    fun getProduct(accessToken: String, page: Int, productDelegate: ProductDelegate, isForce: Boolean)

    fun getCategory(accessToken: String, page: Int, categoryDelegate: CategoryDelegate, isForce: Boolean)

    fun getProductDetail(productId: Int, delegate: ProductDetailDelegate)







}