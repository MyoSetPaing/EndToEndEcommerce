package com.myosetpaing.endtoend.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.myosetpaing.endtoend.R
import com.myosetpaing.endtoend.data.model.EndToEndModel
import com.myosetpaing.endtoend.data.model.EndToEndModelImpl
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.ProductDetailDelegate
import kotlinx.android.synthetic.main.activity_product_details.*
import kotlinx.android.synthetic.main.item_view_category.*

class ProductDetailActivity : BaseActivity(), ProductDetailDelegate {

    private val mEndToEndModel: EndToEndModel

    init {
        mEndToEndModel = EndToEndModelImpl
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProductDetailActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val intent = intent
        val productId = intent.getIntExtra("product_id", 0)
        mEndToEndModel.getProductDetail(productId, this)

        iv_back.setOnClickListener { finish() }

    }


    override fun getProductDetail(product: ProductVO) {

        Glide.with(this)
            .load(product.product_image_url?.get(0)?.image_url)
            .into(iv_productImage)
        tv_product_title.text = product.product_name
        tv_price.text = product.product_price
        tv_desc.text = product.product_desc
        tv_shop_name.text = product.seller?.name
    }

}
