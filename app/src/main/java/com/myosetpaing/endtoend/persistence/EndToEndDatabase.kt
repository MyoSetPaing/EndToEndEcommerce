package com.myosetpaing.endtoend.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.akkt.ecommerce.data.vos.FavoriteVO
import com.akkt.ecommerce.data.vos.LoginUserVO
import com.akkt.ecommerce.persistence.dao.FavouriteDao
import com.akkt.ecommerce.persistence.dao.HistoryDao
import com.akkt.ecommerce.persistence.entities.ProductTable
import com.akkt.ecommerce.persistence.entities.HistoryTable
import com.akkt.ecommerce.persistence.typeconverters.CategoryListConverter
import com.akkt.ecommerce.persistence.typeconverters.ProductImageUrlListConverter
import com.myosetpaing.endtoend.data.vos.CategoryVO
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.persistence.dao.CategoryDao
import com.myosetpaing.endtoend.persistence.dao.LoginDao
import com.myosetpaing.endtoend.persistence.dao.ProductDao


@Database(
    entities = [
        LoginUserVO::class,
        ProductVO::class,
        CategoryVO::class,
        FavoriteVO::class,
        ProductTable::class,
        HistoryTable::class], version = 5, exportSchema = false
)
@TypeConverters(CategoryListConverter::class, ProductImageUrlListConverter::class)

abstract class EndToEndDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    abstract fun categoryDao(): CategoryDao
    abstract fun loginUserDao(): LoginDao
    abstract fun historyDao(): HistoryDao

    abstract fun favouriteDao(): FavouriteDao

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