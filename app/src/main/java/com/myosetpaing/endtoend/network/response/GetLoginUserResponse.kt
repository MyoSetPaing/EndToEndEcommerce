package com.myosetpaing.endtoend.network.response

import com.google.gson.annotations.SerializedName
import com.myosetpaing.endtoend.data.vos.*

data class GetLoginUserResponse(

    @SerializedName("login_user")
    val loginUser: LoginUserVO,

    @SerializedName("favorite_list")
    val favouriteList: List<FavoriteVO>,

    @SerializedName("selling_list")
    val sellingList: List<SellingVO>,

    @SerializedName("sold_list")
    val soldList: List<SoldVO>,

    @SerializedName("bought_list")
    val boughtList: List<BoughtVO>

) : BaseResponse()