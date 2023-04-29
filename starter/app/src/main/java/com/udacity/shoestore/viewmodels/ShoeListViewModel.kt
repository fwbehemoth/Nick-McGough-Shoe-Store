package com.udacity.shoestore.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {
    val shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        shoeList.value = mutableListOf()
    }

    fun addShoeToList(shoe: Shoe){
        shoeList.value?.add(shoe)
    }
}