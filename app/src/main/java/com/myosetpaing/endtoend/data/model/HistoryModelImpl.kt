package com.myosetpaing.endtoend.data.model

import com.myosetpaing.endtoend.delegates.ProductDelegate
import com.myosetpaing.endtoend.persistence.entities.HistoryTable

object HistoryModelImpl: BaseModel(),HistoryModel {


    override fun addToHistory(productId: Int) {
        mDatabase.historyDao().addHistory(HistoryTable(productId = productId))
    }

    override fun getHistory(delegate: ProductDelegate) {
        val historyItem = mDatabase.historyDao().getHistory()

        if(historyItem.isNotEmpty()){
            delegate.onSuccess(historyItem)
        }else{
            delegate.onFail("")
        }

    }
}