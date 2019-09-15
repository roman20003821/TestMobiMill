package com.example.exampleproject.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.exampleproject.model.MapEntity

@Dao
interface MapEntityDao {

    @Query("SELECT * FROM map_entity")
    suspend fun getAllMapEntities(): List<MapEntity>

    @Query("SELECT * FROM map_entity WHERE (SQRT(POWER(:latitude - latitude,2) + POWER(:longitude-longitude,2))<(:radiusKm/110.574))")
    fun getAllFromRegion(latitude: Double, longitude: Double, radiusKm: Int): List<MapEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg mapEntities: MapEntity)

    @Delete
    suspend fun delete(mapEntity: MapEntity)
}