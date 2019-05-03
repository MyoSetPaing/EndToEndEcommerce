package com.akkt.ecommerce.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.akkt.ecommerce.data.vos.FavoriteVO
import com.myosetpaing.endtoend.data.vos.ProductVO


@Dao
interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavouriteList(favourite: List<FavoriteVO>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFavoriteProduct(favorite: FavoriteVO): Long

    @Query("select b.* from favorite as a inner join product as b on a.product_id=b.product_id")
    fun retrieveFavoriteProducts(): List<ProductVO>
}