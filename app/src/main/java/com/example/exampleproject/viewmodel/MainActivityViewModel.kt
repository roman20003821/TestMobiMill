package com.example.exampleproject.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.exampleproject.model.ApplicationRepository
import com.example.exampleproject.model.MapEntity
import com.example.exampleproject.model.db.ApplicationDatabase
import com.example.exampleproject.model.retrofit.WebService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val applicationRepository: ApplicationRepository = ApplicationRepository(
        constructWebServices(), ApplicationDatabase.instance(application.baseContext)
    )

    val mapEntities: MutableLiveData<List<MapEntity>> by lazy { MutableLiveData<List<MapEntity>>() }
    val loading: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    fun showWithRadius(latitude: Double, longitude: Double, radiusKm: Int) {
        viewModelScope.launch {
            try {
                loading.value = true
                applicationRepository.changeLiveDataMapEntities(
                    mapEntities,
                    latitude,
                    longitude,
                    radiusKm
                )
            } catch (e: Exception) {
                Log.e("Data exception", e.toString())
            } finally {
                loading.value = false
            }
        }
    }

    companion object {
        val BASE_URL = "http://app.crazyagro.com:8777"

        private fun constructWebServices(): WebService {
            return productRetrofit().create(WebService::class.java)
        }

        private fun productRetrofit(): Retrofit {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build()
        }
    }

}