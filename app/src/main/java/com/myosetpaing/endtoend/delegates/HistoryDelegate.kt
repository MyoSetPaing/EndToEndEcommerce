package com.myosetpaing.endtoend.delegates

import com.myosetpaing.endtoend.data.vos.ProductVO

interface HistoryDelegate {

    fun onSuccesGettingHistoryProduct(productList:List<ProductVO>)
    fun onFailGettingHistoryProduct(message:String)

}
