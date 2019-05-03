package com.myosetpaing.endtoend.data.model

import android.content.Context
import com.myosetpaing.endtoend.network.EndToEndDA
import com.myosetpaing.endtoend.network.RetrofitDataAgent
import com.myosetpaing.endtoend.persistence.EndToEndDatabase

abstract class BaseModel {

    var mDataAgent: EndToEndDA =RetrofitDataAgent.getInstance()
    lateinit var mDatabase: EndToEndDatabase

    fun initModel(context: Context){
        mDatabase= EndToEndDatabase.getInstance(context)
    }

}