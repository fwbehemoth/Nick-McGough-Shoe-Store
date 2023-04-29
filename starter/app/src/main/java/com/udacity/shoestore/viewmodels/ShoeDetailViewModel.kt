package com.udacity.shoestore.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel: ViewModel() {
    val shoeName = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()

    fun saveShoe(): Shoe{
        Log.i("Shoe Detail", "Save Shoe - Name: ${shoeName.value}")
        val newShoe = Shoe(shoeName.value ?: "", shoeSize.value!!.toDouble(),
            shoeCompany.value ?: "", shoeDescription.value ?: "")

        return newShoe
    }
}