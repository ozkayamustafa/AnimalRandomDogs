package com.mustafa.animalrandomdogs.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.mustafa.animalrandomdogs.R
import com.mustafa.animalrandomdogs.databinding.FragmentDogsBinding
import com.mustafa.animalrandomdogs.viewmodel.DogsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogsFragment : Fragment() {

        private lateinit var binding: FragmentDogsBinding

        private val viewmodel:DogsViewModel by viewModels<DogsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDogsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataObserve()

        //Change Dog Image Click
        binding.changeImage.setOnClickListener {
            viewmodel.getDogsData()
        }


    }

    fun dataObserve(){
        viewmodel.dogsLive.observe(viewLifecycleOwner, Observer {
            Glide.with(requireContext()).load(it.url).into(binding.dogsImage)
        })

        viewmodel.errorLive.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }

}