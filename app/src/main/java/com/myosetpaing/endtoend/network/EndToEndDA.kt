package com.myosetpaing.endtoend.network

import com.myosetpaing.endtoend.delegates.CategoryDelegate
import com.myosetpaing.endtoend.delegates.LoginDelegate

import com.myosetpaing.endtoend.delegates.ProductDelegate

interface EndToEndDA {

    companion object {
        val ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916"
    }

    fun login(phone: String, password: String, loginDelegate: LoginDelegate)

    fun loadCategory(page: Int, accessToken: String, categoryDelegate: CategoryDelegate)

    fun loadProduct(page: Int, accessToken: String, productDelegate: ProductDelegate)


}