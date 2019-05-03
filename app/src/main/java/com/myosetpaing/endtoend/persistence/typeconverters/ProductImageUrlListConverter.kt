package com.akkt.ecommerce.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myosetpaing.endtoend.data.vos.ProductImageUrlVO

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
class ProductImageUrlListConverter {

    @TypeConverter
    fun fromListToJson(imgList: List<ProductImageUrlVO>): String {
        return Gson().toJson(imgList)
    }

    @TypeConverter
    fun fromJsonToList(jsonString: String): List<ProductImageUrlVO> {

        val listType = object : TypeToken<List<ProductImageUrlVO>>() {}.type

        return Gson().fromJson(jsonString, listType)
    }

}