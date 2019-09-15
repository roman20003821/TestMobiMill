package com.example.exampleproject.model

import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.exampleproject.model.db.converters.ImageDTOListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageDTOList(
    @SerializedName("position") @Expose
    @ColumnInfo(name = "position")
    var position : String = "",
    @SerializedName("type") @Expose
    @ColumnInfo(name = "type")
    var type : String = "",
    @SerializedName("imageUrl") @Expose
    @ColumnInfo(name = "imageUrl")
    var imageUrl : String = ""
) {
}