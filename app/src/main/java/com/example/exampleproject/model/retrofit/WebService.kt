package com.example.exampleproject.model.retrofit

import com.example.exampleproject.model.MapEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("/api/discussion")
    fun getMapEntities(@Query("lat") lat:Double, @Query("lng")lng:Double,
                       @Query("radiusKm")radiusKm:Int): Call<List<MapEntity>>
}