package com.myosetpaing.endtoend.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import com.myosetpaing.endtoend.R
import com.myosetpaing.endtoend.adapters.FavoriteRecyclerViewAdapter
import com.myosetpaing.endtoend.adapters.HistoryRecyclerViewAdapter
import com.myosetpaing.endtoend.data.model.HistoryModel
import com.myosetpaing.endtoend.data.model.HistoryModelImpl
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.HistoryDelegate
import com.myosetpaing.endtoend.delegates.ProductDelegate
import com.myosetpaing.endtoend.delegates.ProductItemDelegate
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity(), ProductItemDelegate {


    private var mAdapter: HistoryRecyclerViewAdapter = HistoryRecyclerViewAdapter(this, this)
    private val mHistoryModel: HistoryModel


    init {
        mHistoryModel = HistoryModelImpl
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        rvHistory.adapter = mAdapter
        rvHistory.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        getHistoryList()
        mAdapter.notifyDataSetChanged()
    }

    private fun getHistoryList() {

        mHistoryModel.getHistory(object : ProductDelegate{
            override fun onSuccess(productList: List<ProductVO>) {
                mAdapter.setNewData(productList as MutableList<ProductVO>)
            }

            override fun onFail(mag: String) {
                Toast.makeText(this@ProfileActivity, "No History", Toast.LENGTH_LONG).show()
            }

        })

    }

    override fun onTapProductItem(product: ProductVO) {
        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra("product_id", product.product_id)
        startActivity(intent)
    }

    override fun onTapFavorite(product: ProductVO) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
