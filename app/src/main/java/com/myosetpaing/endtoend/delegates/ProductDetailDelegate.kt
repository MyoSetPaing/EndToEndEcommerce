package com.myosetpaing.endtoend.delegates

import com.myosetpaing.endtoend.data.vos.ProductVO

interface ProductDetailDelegate {

    fun getProductDetail(product: ProductVO)
}