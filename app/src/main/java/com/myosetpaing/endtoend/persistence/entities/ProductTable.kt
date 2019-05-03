package com.akkt.ecommerce.persistence.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import com.myosetpaing.endtoend.data.vos.CategoryVO
import com.myosetpaing.endtoend.data.vos.ProductVO

@Entity(
    tableName = "category_product",
    indices = [Index("product_id"), Index("category_id")],
    primaryKeys = ["product_id", "category_id"],
    foreignKeys = [
        ForeignKey(
            entity = ProductVO::class,
            parentColumns = ["product_id"], childColumns = ["product_id"]
        ),
        ForeignKey(
            entity = CategoryVO::class,
            parentColumns = ["category_id"], childColumns = ["category_id"]
        )]
)
data class ProductTable(

    @ColumnInfo(name = "product_id")
    val productId: Int,

    @ColumnInfo(name = "category_id")
    val categoryId: Int

)