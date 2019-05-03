package com.akkt.ecommerce.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myosetpaing.endtoend.data.vos.CategoryVO

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
class CategoryListConverter {

    @TypeConverter
    fun fromListToJson(categoryList: List<CategoryVO>): String {
        return Gson().toJson(categoryList)
    }

    @TypeConverter
    fun fromJsonToList(jsonString: String): List<CategoryVO> {

        val listType = object : TypeToken<List<CategoryVO>>() {}.type

        return Gson().fromJson(jsonString, listType)
    }

}