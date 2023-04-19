package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.viewmodels.ShoeViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var shoeViewModel: ShoeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
    }
}
