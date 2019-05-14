package com.myosetpaing.endtoend.persistence.entities

import android.arch.persistence.room.*
import com.myosetpaing.endtoend.data.vos.ProductVO

@Entity(
    tableName = "favourite_product",
    indices = [Index("product_id")],
    foreignKeys = [ForeignKey(
        entity = ProductVO::class
        , parentColumns = ["product_id"], childColumns = ["product_id"]
    )]
)
data class FavouriteTable(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "favourite_pk")
    val favouritePk: Int,

    @ColumnInfo(name = "product_id")
    val productId: Int
)