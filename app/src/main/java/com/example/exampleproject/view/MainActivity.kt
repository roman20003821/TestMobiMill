package com.example.exampleproject.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.exampleproject.R
import com.example.exampleproject.viewmodel.MainActivityViewModel
import com.example.testapplication.view.ListFragment
import com.example.testapplication.view.MapFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    enum class Mode {
        MAP_MODE, RADIUS_MODE
    }

    private var currentMode = Mode.MAP_MODE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        setSupportActionBar(toolbar)
        showStartView()
        addOnClickListeners()
    }

    private fun showStartView() {
        showFragment(MapFragment())
    }

    private fun showFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun addOnClickListeners() {
        listButton.setOnClickListener { showFragment(ListFragment()) }
        mapButton.setOnClickListener { showFragment(MapFragment()) }
    }
}
