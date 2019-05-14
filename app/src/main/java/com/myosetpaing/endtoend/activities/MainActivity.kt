package com.myosetpaing.endtoend.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.myosetpaing.endtoend.R
import com.myosetpaing.endtoend.Utils.BottomOffsetDecoration
import com.myosetpaing.endtoend.adapters.CategoryRecyclerViewAdapter
import com.myosetpaing.endtoend.adapters.ProductRecyclerViewAdapter
import com.myosetpaing.endtoend.data.model.*
import com.myosetpaing.endtoend.data.vos.CategoryVO
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.*
import com.myosetpaing.endtoend.network.EndToEndDA
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view_product.*

class MainActivity : BaseActivity(), CategoryItemDelegate, ProductItemDelegate {


    private val mEndToEndModel: EndToEndModel
    private val mLoginModel: LoginModel
    private val mFavoriteModel: FavoriteModel
    private val mHistoryModel: HistoryModel
    private lateinit var bottomOffsetDecoration: BottomOffsetDecoration
    private val mCategoryAdapter: CategoryRecyclerViewAdapter
    private val mProductAdapter: ProductRecyclerViewAdapter

    private var isFavorite: Boolean = false

    init {
        mEndToEndModel = EndToEndModelImpl
        mLoginModel = LoginModelImpl
        mFavoriteModel = FavoriteModelImpl
        mHistoryModel = HistoryModelImpl
        mCategoryAdapter = CategoryRecyclerViewAdapter(this, this)
        mProductAdapter = ProductRecyclerViewAdapter(this, this)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBottomOffsetDecoration()


        if (mLoginModel.isUserLogin()) {
            rv_category.adapter = mCategoryAdapter
            rv_category.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
            rv_productList.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
            rv_productList.adapter = mProductAdapter
            rv_productList.addItemDecoration(bottomOffsetDecoration)
            BindProduct()



            bottomBar.replaceMenu(R.menu.menu_bottom_view)
            bottomBar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_home -> goToMainActivity()
                    R.id.action_profile -> goToProfileActivity()
                }
                true
            }

            fab.setOnClickListener {
                startActivity(FavoriteActivity.newIntent(this))
            }
        } else {
            startActivity(LoginActivity.newIntent(this))
            finish()
        }

    }

    private fun goToMainActivity() {
        startActivity(MainActivity.newIntent(this))
        finish()
    }

    private fun goToProfileActivity() {
        startActivity(ProfileActivity.newIntent(this))

    }

    private fun setBottomOffsetDecoration() {
        bottomOffsetDecoration = BottomOffsetDecoration(resources.getDimension(R.dimen.bottom_offset_dp).toInt())
    }

    private fun BindProduct() {
        mEndToEndModel.getProduct(EndToEndDA.ACCESS_TOKEN, 1, object : ProductDelegate {
            override fun onSuccess(productList: List<ProductVO>) {
                mProductAdapter.setNewData(productList.toMutableList())
            }

            override fun onFail(mag: String) {

                Log.d("Error", mag)
                Toast.makeText(this@MainActivity, mag, Toast.LENGTH_LONG).show()
            }


        }, true)

        mEndToEndModel.getCategory(EndToEndDA.ACCESS_TOKEN, 1, object : CategoryDelegate {
            override fun onSuccess(categoryList: List<CategoryVO>) {
                mCategoryAdapter.setNewData(categoryList.toMutableList())

            }

            override fun onFail(mag: String) {
                Log.d("Error", mag)
                Toast.makeText(this@MainActivity, mag, Toast.LENGTH_LONG).show()
            }

        }, true)
    }

    override fun onTapFavorite(productVO: ProductVO) {
        val favItem = mFavoriteModel.addToFavorite(productVO)
        if (favItem > 0) {

        } else {
            mFavoriteModel.removeFromFavorite(productVO.product_id)
        }


    }

    override fun onTapCategoryItem() {
        Toast.makeText(this@MainActivity, "Tap Category", Toast.LENGTH_LONG).show()

    }

    override fun onTapProductItem(product: ProductVO) {
        mHistoryModel.addToHistory(product.product_id)

        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra("product_id", product.product_id)
        startActivity(intent)
    }
}
