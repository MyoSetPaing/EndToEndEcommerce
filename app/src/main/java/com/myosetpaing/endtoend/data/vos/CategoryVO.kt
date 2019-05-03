package com.myosetpaing.endtoend.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(tableName = "category")
class CategoryVO {
    @PrimaryKey
    @ColumnInfo(name = "category_id")
    @SerializedName("category_id")
    var category_id: Int = 0

    @ColumnInfo(name = "category_name")
    @SerializedName("category_name")
    var category_name: String? = null

    @ColumnInfo(name = " category_icon")
    @SerializedName("category_icon")
    var category_icon: String? = null

    @ColumnInfo(name = "category_color ")
    @SerializedName("category_color")
    var category_color: String? = null
}

