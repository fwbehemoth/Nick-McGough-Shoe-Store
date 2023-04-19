package com.udacity.shoestore.viewmodels

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel {
    var shoeList: MutableLiveData<MutableList<Shoe>>

    constructor() : super() {
        this.shoeList = initializeShoeList()
    }

    private fun initializeShoeList():MutableLiveData<MutableList<Shoe>>{
        var newShoeList = MutableLiveData<MutableList<Shoe>>()
        var nikeShoe10 = Shoe("Air Jordan", 10.0, "Nike", "White and Grey")
        newShoeList.value?.add(nikeShoe10)

        var nikeShoe11 = Shoe("Air Jordan", 11.0, "Nike", "Red and Black")
        newShoeList.value?.add(nikeShoe11)

        var adidasShoe8 = Shoe("Trainer", 8.0, "Adidas", "Yellow and Green")
        newShoeList.value?.add(nikeShoe11)
        return newShoeList
    }

    public fun addItem(shoe:Shoe){
        shoeList.value?.add(shoe)
    }
}