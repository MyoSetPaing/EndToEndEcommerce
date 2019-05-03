package com.myosetpaing.endtoend.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.myosetpaing.endtoend.R
import com.myosetpaing.endtoend.adapters.CategoryRecyclerViewAdapter
import com.myosetpaing.endtoend.adapters.ProductRecyclerViewAdapter
import com.myosetpaing.endtoend.data.model.EndToEndModel
import com.myosetpaing.endtoend.data.model.EndToEndModelImpl
import com.myosetpaing.endtoend.data.model.LoginModel
import com.myosetpaing.endtoend.data.model.LoginModelImpl
import com.myosetpaing.endtoend.data.vos.CategoryVO
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.delegates.*
import com.myosetpaing.endtoend.network.EndToEndDA
import com.myosetpaing.endtoend.network.RetrofitDataAgent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), CategoryItemDelegate, ProductItemDelegate {


    private val mEndToEndModel: EndToEndModel
    private val mLoginModel: LoginModel

    private val mCategoryAdapter: CategoryRecyclerViewAdapter
    private val mProductAdapter: ProductRecyclerViewAdapter

    init {
        mEndToEndModel = EndToEndModelImpl
        mLoginModel = LoginModelImpl
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


        if(mLoginModel.isUserLogin()){
            rv_category.adapter = mCategoryAdapter
            rv_category.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
            rv_productList.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
            rv_productList.adapter = mProductAdapter
            BindProduct()



            fab.setOnClickListener {
                val intent = Intent(applicationContext, ProductDetailActivity::class.java)
                startActivity(intent)
            }
        }else{
            startActivity(LoginActivity.newIntent(this))
            finish()
        }




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

    override fun onTapCategoryItem() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapProductItem(product: ProductVO) {
        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra("product_id", product.product_id)
        startActivity(intent)
    }
}
