package com.myosetpaing.endtoend.network.response

import com.google.gson.annotations.SerializedName
import com.myosetpaing.endtoend.data.vos.CategoryVO

class GetCategoryResponse : BaseResponse(){
    @SerializedName("categoryList")
    var categoryList: List<CategoryVO> ? = null
}




