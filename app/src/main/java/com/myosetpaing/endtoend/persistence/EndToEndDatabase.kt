package com.myosetpaing.endtoend.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context


import com.myosetpaing.endtoend.data.vos.CategoryVO
import com.myosetpaing.endtoend.data.vos.FavoriteVO
import com.myosetpaing.endtoend.data.vos.LoginUserVO
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.persistence.dao.*
import com.myosetpaing.endtoend.persistence.entities.HistoryTable
import com.myosetpaing.endtoend.persistence.entities.ProductTable
import com.myosetpaing.endtoend.persistence.typeconverters.CategoryListConverter
import com.myosetpaing.endtoend.persistence.typeconverters.DateConverter
import com.myosetpaing.endtoend.persistence.typeconverters.ProductImageUrlListConverter


@Database(
    entities = [
        LoginUserVO::class,
        ProductVO::class,
        CategoryVO::class,
        FavoriteVO::class,
        ProductTable::class,
        HistoryTable::class], version = 6, exportSchema = false
)
@TypeConverters(CategoryListConverter::class, ProductImageUrlListConverter::class, DateConverter::class)

abstract class EndToEndDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    abstract fun categoryDao(): CategoryDao
    abstract fun loginUserDao(): LoginDao

    abstract fun favouriteDao(): FavouriteDao

    abstract fun historyDao(): HistoryDao

    companion object {
        private var INSTANCE: EndToEndDatabase? = null

        fun getInstance(context: Context): EndToEndDatabase {

            INSTANCE = Room.databaseBuilder(context, EndToEndDatabase::class.java, "EndToEnd.DB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                .build()
            return INSTANCE!!

        }
    }

    fun isUserLogin(): Boolean {

        val count = loginUserDao().getUserCount()
        if (count > 0) {
            return true
        }
        return false
    }

    fun isFavorite(productId:Int): Boolean {
        val count = favouriteDao().getFavoriteCount(productId)
        if (count >=0) {
            return true
        } else if (count == 0) {
            return false
        }
        return false
    }

    fun isProductAvailable(): Boolean {

        val count = productDao().getProductCount()
        if (count > 0) {
            return true
        }
        return false
    }

    fun isCategoryAvailable(): Boolean {

        val count = categoryDao().getCategoryCount()
        if (count > 0) {
            return true
        }
        return false
    }


}