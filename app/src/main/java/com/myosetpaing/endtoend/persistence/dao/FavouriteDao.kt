package com.myosetpaing.endtoend.persistence.dao

import android.arch.persistence.room.*
import com.myosetpaing.endtoend.data.vos.FavoriteVO
import com.myosetpaing.endtoend.data.vos.ProductVO


@Dao
interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavouriteList(favourite: List<FavoriteVO>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFavoriteProduct(favorite: FavoriteVO): Long

    @Query("select b.* from favorite as a inner join product as b on a.product_id=b.product_id")
    fun retrieveFavoriteProducts(): List<ProductVO>

    @Query("select * from favorite where product_id=:productId")
    fun getFavoriteCount(productId: Int): Int

    @Query("Delete from favorite where product_id= :productId")
    fun removeFavoriteProducts(productId: Int)
}