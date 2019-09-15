package com.example.exampleproject.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.exampleproject.model.db.ApplicationDatabase
import com.example.exampleproject.model.retrofit.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApplicationRepository(
    private val webService: WebService,
    applicationDb: ApplicationDatabase
) {
    private val mapEntityDao = applicationDb.mapEntityDao()

    suspend fun changeLiveDataMapEntities(
        liveData: MutableLiveData<List<MapEntity>>,
        latitude: Double,
        longitude: Double,
        radiusKm: Int
    ) {
        withContext(Dispatchers.IO){
            liveData.postValue(getCachedEntities(latitude, longitude, radiusKm))
            liveData.postValue(loadDataAndRefreshCache(latitude, longitude, radiusKm))
        }
    }

    private suspend fun getCachedEntities(
        latitude: Double,
        longitude: Double,
        radiusKm: Int
    ): List<MapEntity> {
        return withContext(Dispatchers.IO) {
            return@withContext mapEntityDao.getAllFromRegion(latitude, longitude, radiusKm)
        }
    }

    private suspend fun loadDataAndRefreshCache(
        latitude: Double,
        longitude: Double,
        radiusKm: Int
    ): List<MapEntity> {
        val response = webService.getMapEntities(latitude, longitude, radiusKm).execute()
        if (response.body() == null) return ArrayList()
        mapEntityDao.insertAll(*getArrayOfMapEntities(response.body()!!))
        return response.body()!!
    }

    private fun getArrayOfMapEntities(list: List<MapEntity>): Array<MapEntity> {
        return Array(list.size) { list[it] }
    }
}