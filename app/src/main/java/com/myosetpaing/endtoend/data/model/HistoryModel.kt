package com.myosetpaing.endtoend.data.model

import com.myosetpaing.endtoend.delegates.ProductDelegate

interface HistoryModel {
    fun addToHistory(productId: Int)
    fun getHistory(delegate: ProductDelegate)

}