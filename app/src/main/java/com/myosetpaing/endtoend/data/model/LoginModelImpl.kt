package com.myosetpaing.endtoend.data.model

import com.myosetpaing.endtoend.data.vos.LoginUserVO
import com.myosetpaing.endtoend.delegates.LoginDelegate
import com.myosetpaing.endtoend.network.response.GetLoginUserResponse

object LoginModelImpl : BaseModel(), LoginModel {


    override fun login(phone: String, password: String, loginDelegate: LoginDelegate) {
        mDataAgent.login(phone, password, object : LoginDelegate {
            override fun onSuccess(loginUser: GetLoginUserResponse) {
                mDatabase.loginUserDao().insertLoginUser(loginUser.loginUser)
                mDatabase.favouriteDao().addFavouriteList(loginUser.favouriteList)
                loginDelegate.onSuccess(loginUser)

            }

            override fun onFail(message: String) {
                loginDelegate.onFail(message)
            }

        })
    }

    override fun isUserLogin(): Boolean {
        return mDatabase.isUserLogin()
    }

    override fun getUserInformation(): LoginUserVO {
        val loginUser = mDatabase.loginUserDao().getUserInformation()

        return loginUser
    }

}