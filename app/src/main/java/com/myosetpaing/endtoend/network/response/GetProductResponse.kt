package com.myosetpaing.endtoend.network.response

import com.google.gson.annotations.SerializedName
import com.myosetpaing.endtoend.data.vos.ProductVO


class GetProductResponse : BaseResponse() {

    @SerializedName("products")
    var productList: List<ProductVO>? = null
}




