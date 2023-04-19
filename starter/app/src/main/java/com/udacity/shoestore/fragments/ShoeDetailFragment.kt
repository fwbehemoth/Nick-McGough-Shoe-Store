package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.viewmodels.ShoeViewModel

class ShoeDetailFragment : Fragment() {
    lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        shoeViewModel = ViewModelProvider(activity!!).get(ShoeViewModel::class.java)

        binding.shoeDetailSaveButton.setOnClickListener { view: View ->

            Navigation.findNavController(view).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        binding.shoeDetailCancelButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        return  binding.root
    }
}