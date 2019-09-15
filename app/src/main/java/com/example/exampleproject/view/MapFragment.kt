package com.example.testapplication.view

import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.exampleproject.R
import com.example.exampleproject.viewmodel.MainActivityViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.fragment_map.*


class MapFragment() : Fragment(), OnMapReadyCallback {
    private var googleMap: GoogleMap? = null
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        initViews()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onMapReady(map: GoogleMap?) {
        googleMap = map
    }

    private fun initViews() {
        observeViewModelData()
        addOnClickListeners()
    }

    private fun observeViewModelData() {
        observeMapEntities()
        observeLoadingView()
    }

    private fun observeMapEntities() {
        viewModel.mapEntities.observe(this, Observer {
        })
    }

    private fun observeLoadingView() {
        viewModel.loading.observe(this, Observer {
            if (it == true)
                loadingView.visibility = View.VISIBLE
            else if (it == false)
                loadingView.visibility = View.INVISIBLE
        })
    }

    private fun addOnClickListeners() {
        showForArea.setOnClickListener { onShowForAreaClick() }
        showForRadius.setOnClickListener { onShowForRadiusClick() }
    }

    private fun onShowForAreaClick() {

    }

    private fun onShowForRadiusClick() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null)
                    viewModel.showWithRadius(location.latitude, location.latitude, 50000)
            }
    }
}
