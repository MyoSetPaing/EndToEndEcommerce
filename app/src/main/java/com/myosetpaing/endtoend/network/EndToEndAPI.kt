package com.myosetpaing.endtoend.network

import com.myosetpaing.endtoend.network.response.GetCategoryResponse
import com.myosetpaing.endtoend.network.response.GetLoginUserResponse
import com.myosetpaing.endtoend.network.response.GetProductResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface EndToEndAPI{
    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("phone") phone: String, @Field("password") password: String): Call<GetLoginUserResponse>
    @FormUrlEncoded
    @POST("getCategory.php")
    fun loadCategory(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetCategoryResponse>

    @FormUrlEncoded
    @POST("getProducts.php")
    fun loadProduct(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetProductResponse>
}