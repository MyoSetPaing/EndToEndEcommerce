package com.myosetpaing.endtoend.delegates

import com.myosetpaing.endtoend.network.response.GetLoginUserResponse

interface LoginDelegate :BaseNetworkDelegate {

    fun onSuccess(loginUser : GetLoginUserResponse)
}