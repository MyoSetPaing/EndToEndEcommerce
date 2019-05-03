package com.myosetpaing.endtoend.network

import com.google.gson.Gson
import com.myosetpaing.endtoend.delegates.CategoryDelegate
import com.myosetpaing.endtoend.delegates.LoginDelegate
import com.myosetpaing.endtoend.delegates.ProductDelegate
import com.myosetpaing.endtoend.network.response.GetCategoryResponse
import com.myosetpaing.endtoend.network.response.GetLoginUserResponse
import com.myosetpaing.endtoend.network.response.GetProductResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitDataAgent : EndToEndDA {


    private val productAPI: EndToEndAPI

    companion object {
        private var INSTANCE: RetrofitDataAgent? = null

        fun getInstance(): RetrofitDataAgent {
            if (INSTANCE == null) {
                INSTANCE = RetrofitDataAgent()
            }
            val i = INSTANCE
            return i!!
        }
    }

    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://padcmyanmar.com/padc-3/final-projects/e-commerce/fun/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()
        productAPI = retrofit.create(EndToEndAPI::class.java)
    }

    override fun login(phone: String, password: String, loginDelegate: LoginDelegate) {

        productAPI.login(phone, password).enqueue(object : Callback<GetLoginUserResponse> {
            override fun onFailure(call: Call<GetLoginUserResponse>, t: Throwable) {
                loginDelegate.onFail(t.message!!)

            }

            override fun onResponse(call: Call<GetLoginUserResponse>, response: Response<GetLoginUserResponse>) {
                val loginUserResponse = response.body()

                if (loginUserResponse!!.isResponseSuccess()) {
                    loginDelegate.onSuccess(loginUserResponse)
                } else {
                    loginDelegate.onFail("Login Response is fail")
                }
            }

        })
    }


    override fun loadCategory(page: Int, accessToken: String, categoryDelegate: CategoryDelegate) {
        productAPI.loadCategory(accessToken, page).enqueue(object : Callback<GetCategoryResponse> {
            override fun onFailure(call: Call<GetCategoryResponse>, t: Throwable) {
                categoryDelegate.onFail(t.message!!)
            }

            override fun onResponse(call: Call<GetCategoryResponse>, response: Response<GetCategoryResponse>) {
                val categoryListResponse = response.body()

                if (categoryListResponse!!.isResponseSuccess()) {
                    categoryDelegate.onSuccess(categoryList = categoryListResponse.categoryList!!)
                } else {
                    categoryDelegate.onFail("Can't get category list")
                }
            }

        })

    }

    override fun loadProduct(page: Int, accessToken: String, productDelegate: ProductDelegate) {
        productAPI.loadProduct(accessToken, page).enqueue(object : Callback<GetProductResponse> {
            override fun onFailure(call: Call<GetProductResponse>, t: Throwable) {
                productDelegate.onFail(t.message!!)
            }

            override fun onResponse(call: Call<GetProductResponse>, response: Response<GetProductResponse>) {
                val productListResponse = response.body()

                if (productListResponse!!.isResponseSuccess()) {
                    productDelegate.onSuccess(productList = productListResponse.productList!!)
                } else {
                    productDelegate.onFail("Can't get product list")
                }
            }

        })
    }
}