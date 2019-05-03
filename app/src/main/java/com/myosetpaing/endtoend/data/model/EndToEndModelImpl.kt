package com.myosetpaing.endtoend.data.model

import com.myosetpaing.endtoend.data.vos.CategoryVO
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.*

object EndToEndModelImpl  : BaseModel(), EndToEndModel {


    override fun getProduct(
        accessToken: String,
        page: Int,
        productDelegate: ProductDelegate,
        isForce: Boolean
    ) {
        mDataAgent.loadProduct(1,

            accessToken, object : ProductDelegate {
                override fun onFail(mag: String) {
                    productDelegate.onFail(mag)
                }

                override fun onSuccess(productList: List<ProductVO>) {
                    mDatabase.productDao().insertProductList(productList)
                    val mProductList = mDatabase.productDao().getProductList()
                    productDelegate.onSuccess(mProductList)


                }


            })
    }

    override fun getCategory(accessToken: String, page: Int, categoryDelegate: CategoryDelegate, isForce: Boolean) {
        mDataAgent.loadCategory(1,
            accessToken, object : CategoryDelegate {
                override fun onSuccess(categoryList: List<CategoryVO>) {
                    mDatabase.categoryDao().insertCategoryList(categoryList)
                    val mCategoryList = mDatabase.categoryDao().getCategoryList()
                    categoryDelegate.onSuccess(mCategoryList)

                }

                override fun onFail(mag: String) {
                    categoryDelegate.onFail(mag)

                }


            })
    }

    override fun getProductDetail(productId: Int, delegate: ProductDetailDelegate) {
        val product = mDatabase.productDao().getProductById(productId)
        delegate.getProductDetail(product)    }
}