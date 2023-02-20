package com.example.sidedrawerapplication.ui.home

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.sidedrawerapplication.R
import com.example.sidedrawerapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        Glide.with(requireContext())
            .load("https://res.cloudinary.com/manoylo/image/upload/v1587071129/gra4160vm052y91thb8k.jpg")
            .placeholder(R.drawable.animate_loading)
            .centerCrop()
            .into(_binding!!.ivProfilePic)

        _binding!!.tvDescription.movementMethod = LinkMovementMethod.getInstance()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}