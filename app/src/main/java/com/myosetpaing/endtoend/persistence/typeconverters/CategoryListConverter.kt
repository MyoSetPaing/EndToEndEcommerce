package com.myosetpaing.endtoend.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myosetpaing.endtoend.data.vos.CategoryVO

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