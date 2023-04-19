package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.HorizontalScrollView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.viewmodels.ShoeViewModel

class ShoeListFragment : Fragment() {
    lateinit var shoeViewModel: ShoeViewModel
    lateinit var shoeListTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        shoeViewModel = ViewModelProvider(activity!!).get(ShoeViewModel::class.java)
        shoeListTextView = binding.shoeListListText

        binding.shoeListActionButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        refreshList()
        return  binding.root
    }

    fun refreshList(){
        var shoeTextList = StringBuilder()
        for (shoe in shoeViewModel.shoeList.value!!.listIterator()){
            shoeTextList.append("name:${shoe.name} size:${shoe.size}")
        }
        shoeListTextView.text = shoeTextList.toString()
    }
}