package com.myosetpaing.endtoend.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.myosetpaing.endtoend.data.vos.ProductVO

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductList(productList: List<ProductVO>)

    @Query("select * from product")
    fun getProductList(): List<ProductVO>

    @Query("select * from product where product_id=:productId")
    fun getProductById(productId: Int): ProductVO

    @Query("select count(*) from product")
    fun getProductCount(): Int



}