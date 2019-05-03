package com.myosetpaing.endtoend.delegates

import com.myosetpaing.endtoend.data.vos.CategoryVO

interface CategoryDelegate : BaseNetworkDelegate{
    fun onSuccess(categoryList: List<CategoryVO>)
}
