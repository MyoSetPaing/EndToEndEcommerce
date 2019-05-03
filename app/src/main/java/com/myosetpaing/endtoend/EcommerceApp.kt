package com.myosetpaing.endtoend

import android.app.Application
import com.myosetpaing.endtoend.data.model.BaseModel
import com.myosetpaing.endtoend.data.model.EndToEndModelImpl
import com.myosetpaing.endtoend.data.model.LoginModelImpl

class EcommerceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        EndToEndModelImpl.initModel(applicationContext)
        LoginModelImpl.initModel(applicationContext)

    }
}