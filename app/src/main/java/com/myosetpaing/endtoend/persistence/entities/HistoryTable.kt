package com.akkt.ecommerce.persistence.entities

import android.arch.persistence.room.*
import com.myosetpaing.endtoend.data.vos.ProductVO


@Entity(
    tableName = "history",
    indices = [Index("product_id")],
    foreignKeys = [ForeignKey(
        entity = ProductVO::class
        , parentColumns = ["product_id"], childColumns = ["product_id"]
    )]
)
data class HistoryTable(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "history_id")
    val historyId: Int? = null,

    @ColumnInfo(name = "product_id")
    val productId: Int
)