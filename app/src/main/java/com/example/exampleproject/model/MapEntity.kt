package com.example.exampleproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.exampleproject.model.db.converters.ImageDTOListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "map_entity")
data class MapEntity(
    @SerializedName("discussionId") @Expose
    @PrimaryKey
    var discussionId : Int = 0,
    @SerializedName("description") @Expose
    @ColumnInfo(name = "description")
    var description : String = "",
    @SerializedName("address") @Expose
    @ColumnInfo(name = "address")
    var address : String = "",
    @SerializedName("lastAgrotechnicalAction") @Expose
    @ColumnInfo(name = "lastAgrotechnicalAction")
    var lastAgrotechnicalAction : String = "",
    @SerializedName("plantPredecessor") @Expose
    @ColumnInfo(name = "plantPredecessor")
    var plantPredecessor : String ="",
    @SerializedName("creatorName") @Expose
    @ColumnInfo(name = "creatorName")
    var creatorName : String = "",
    @SerializedName("iconUrl") @Expose
    @ColumnInfo(name = "iconUrl")
    var iconUrl : String = "",
    @SerializedName("rainfall") @Expose
    @ColumnInfo(name = "rainfall")
    var rainfall : Int = 0,
    @SerializedName("cultureId") @Expose
    @ColumnInfo(name = "cultureId")
    var cultureId : Int = 0,
    @SerializedName("problemId") @Expose
    @ColumnInfo(name = "problemId")
    var problemId : Int = 0,
    @SerializedName("creatorId") @Expose
    @ColumnInfo(name = "creatorId")
    var creatorId : Int = 0,
    @SerializedName("localityTypeId") @Expose
    @ColumnInfo(name = "localityTypeId")
    var localityTypeId : Int = 0,
    @SerializedName("createDateUNIX") @Expose
    @ColumnInfo(name = "createDateUNIX")
    var createDateUNIX : Long = 0,
    @SerializedName("commentsAmount") @Expose
    @ColumnInfo(name = "commentsAmount")
    var commentsAmount : Int = 0,
    @SerializedName("latitude") @Expose
    @ColumnInfo(name = "latitude")
    var latitude : Double = .0,
    @SerializedName("longitude") @Expose
    @ColumnInfo(name = "longitude")
    var longitude : Double =.0,
    @SerializedName("daytimeTemperature") @Expose
    @ColumnInfo(name = "daytimeTemperature")
    var daytimeTemperature : Int = 0,
    @SerializedName("nightTemperature") @Expose
    @ColumnInfo(name = "nightTemperature")
    var nightTemperature : Int = 0,
    @SerializedName("imageDTOList") @Expose
    @ColumnInfo(name = "imageDTOList")
    @TypeConverters(ImageDTOListConverter::class)
    var imageDTOList : List<ImageDTOList>? =null,
    @SerializedName("expectedImageAmount") @Expose
    @ColumnInfo(name = "expectedImageAmount")
    var expectedImageAmount : Int = 0,
    @SerializedName("public") @Expose
    @ColumnInfo(name = "public")
    var public : Boolean = false,
    @SerializedName("promo") @Expose
    @ColumnInfo(name = "promo")
    var promo : Boolean = false
) {
}