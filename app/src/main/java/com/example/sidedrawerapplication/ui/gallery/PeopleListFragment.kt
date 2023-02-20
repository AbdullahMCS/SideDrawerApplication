package com.example.sidedrawerapplication.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sidedrawerapplication.databinding.FragmentPeopleListBinding
import com.example.sidedrawerapplication.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleListFragment : Fragment() {

    private var _binding: FragmentPeopleListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PeopleListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeopleListBinding.inflate(inflater, container, false)

        viewModel.getPeopleList()
        viewModel.peopleList.observe(viewLifecycleOwner) { response ->
            when(response) {
                is NetworkResult.Loading -> {
                    Toast.makeText(context, "Loading...!", Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Success -> {
                    _binding?.rvPeopleList?.adapter = PeopleAdapter(response.data!!)
                }
                is NetworkResult.Error -> {
                    Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        _binding?.swiperLayout?.apply {
            setOnRefreshListener {
                viewModel.getPeopleList()
                isRefreshing = false
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}