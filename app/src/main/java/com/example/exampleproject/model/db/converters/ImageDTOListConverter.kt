package com.example.exampleproject.model.db.converters

import androidx.room.TypeConverter
import com.example.exampleproject.model.ImageDTOList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ImageDTOListConverter {
    @TypeConverter
    fun fromString(value: String): List<ImageDTOList> {
        val objects = Gson().fromJson(value, Array<ImageDTOList>::class.java) as Array<ImageDTOList>
        return objects.toList()
    }

    @TypeConverter
    fun fromImageDTOList(imageDTOList: List<ImageDTOList>): String {
        return Gson().toJson(imageDTOList)
    }
}