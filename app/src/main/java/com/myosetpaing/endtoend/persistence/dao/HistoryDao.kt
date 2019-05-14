package com.myosetpaing.endtoend.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.myosetpaing.endtoend.data.vos.ProductVO
import com.myosetpaing.endtoend.persistence.entities.HistoryTable

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHistory(history: HistoryTable)

    @Query("select b.* from history as a inner join product as b on a.product_id=b.product_id order by updated_at desc")
    fun getHistory(): List<ProductVO>
}