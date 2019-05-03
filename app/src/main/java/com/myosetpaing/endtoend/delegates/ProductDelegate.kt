package com.myosetpaing.endtoend.delegates

import com.myosetpaing.endtoend.data.vos.ProductVO

interface ProductDelegate : BaseNetworkDelegate {
    fun onSuccess(productList: List<ProductVO>)
}