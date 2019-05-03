package com.myosetpaing.endtoend.data.model

import com.akkt.ecommerce.data.vos.LoginUserVO
import com.myosetpaing.endtoend.delegates.LoginDelegate

interface LoginModel {

    fun login(phone: String, password: String, loginDelegate: LoginDelegate)

    fun isUserLogin(): Boolean

    fun getUserInformation(): LoginUserVO

}