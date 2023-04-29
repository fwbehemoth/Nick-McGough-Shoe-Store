package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeListViewModel

class ShoeListFragment : Fragment() {
    lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        shoeListViewModel = ViewModelProvider(activity!!).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = shoeListViewModel
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)

        shoeListViewModel.shoeList.observe(activity!!, Observer {shoeList ->
            for (shoe in shoeList){
                addShoeItemToListView(binding, container, shoe)
            }
        })

        binding.shoeListActionButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        return  binding.root
    }

    fun addShoeItemToListView(binding: FragmentShoeListBinding, container: ViewGroup?, shoe: Shoe){
        val shoeBinding: ItemShoeListBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_shoe_list, container, false
        )
        shoeBinding.shoe = shoe
        binding.shoeListLinearLayout.addView(shoeBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_shoe_list_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_item_logout -> findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        }

        return true
    }
}