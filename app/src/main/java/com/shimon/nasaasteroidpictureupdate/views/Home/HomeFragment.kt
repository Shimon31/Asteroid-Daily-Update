package com.shimon.nasaasteroidpictureupdate.views.Home

import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide

import com.shimon.nasaasteroidpictureupdate.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.imageOfTheDay.observe(viewLifecycleOwner){ imageOfTheDay ->

            val image = imageOfTheDay.hdurl

            Glide.with(this).load(image).into(binding.imageView)


        }
    }
}
