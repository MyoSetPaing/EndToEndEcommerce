package com.myosetpaing.endtoend.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.myosetpaing.endtoend.data.vos.CategoryVO


@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoryList(categoryList: List<CategoryVO>)

    @Query("select * from category")
    fun getCategoryList(): List<CategoryVO>

    @Query("select count(*) from category")
    fun getCategoryCount(): Int
}