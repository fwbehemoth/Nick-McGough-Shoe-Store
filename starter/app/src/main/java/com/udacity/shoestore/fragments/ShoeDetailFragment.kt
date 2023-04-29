package com.udacity.shoestore.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.viewmodels.ShoeDetailViewModel
import com.udacity.shoestore.viewmodels.ShoeListViewModel

class ShoeDetailFragment : Fragment() {
    lateinit var shoeDetailViewModel: ShoeDetailViewModel
    lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        shoeDetailViewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.shoeViewModel = shoeDetailViewModel
        binding.lifecycleOwner = this

        shoeListViewModel = ViewModelProvider(activity!!).get(ShoeListViewModel::class.java)

        binding.shoeDetailSaveButton.setOnClickListener { view: View ->
            val shoe = shoeDetailViewModel.saveShoe()
            Log.d("Shoe Detail", "Shoe ${shoe.name}")
            shoeListViewModel.addShoeToList(shoe)
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        binding.shoeDetailCancelButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return  binding.root
    }
}