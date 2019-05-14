package com.myosetpaing.endtoend.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.WindowManager
import android.widget.Toast
import com.myosetpaing.endtoend.R
import com.myosetpaing.endtoend.adapters.FavoriteRecyclerViewAdapter
import com.myosetpaing.endtoend.data.model.FavoriteModel
import com.myosetpaing.endtoend.data.model.FavoriteModelImpl
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.FavoriteDelegate
import com.myosetpaing.endtoend.delegates.ProductItemDelegate
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : BaseActivity(), ProductItemDelegate {


    private var mAdapter: FavoriteRecyclerViewAdapter
    private val mFavoriteModel: FavoriteModel

    init {
        mAdapter = FavoriteRecyclerViewAdapter(this, this)
        mFavoriteModel = FavoriteModelImpl
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, FavoriteActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        rvFavorite.adapter = mAdapter
        rvFavorite.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        getFavoriteList()
        mAdapter.notifyDataSetChanged()
    }

    private fun getFavoriteList() {

        mFavoriteModel.getFavoriteProduct(object : FavoriteDelegate {
            override fun onSuccesGettingFavoriteProduct(productList: List<ProductVO>) {

                mAdapter.setNewData(productList as MutableList<ProductVO>)

            }

            override fun onFailGettingFavoriteProduct(message: String) {
                Toast.makeText(this@FavoriteActivity, message, Toast.LENGTH_LONG).show()

            }

        })

    }

    override fun onTapProductItem(product: ProductVO) {

    }

    override fun onTapFavorite(product: ProductVO) {
        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra("product_id", product.product_id)
        startActivity(intent)
    }
}
