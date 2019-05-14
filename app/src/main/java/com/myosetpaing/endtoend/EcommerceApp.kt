package com.myosetpaing.endtoend

import android.app.Application
import com.myosetpaing.endtoend.data.model.*

class EcommerceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        EndToEndModelImpl.initModel(applicationContext)
        LoginModelImpl.initModel(applicationContext)
        FavoriteModelImpl.initModel(applicationContext)
        HistoryModelImpl.initModel(applicationContext)


    }
}