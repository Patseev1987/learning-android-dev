package com.example.rings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rings.databinding.FragmentFindRingBinding
import com.example.rings.model.RingDatabase
import com.example.rings.recycleview.RingAdapter
import com.example.rings.viewmodels.vmfind.FindViewModel
import com.example.rings.viewmodels.vmfind.FindViewModelFactory


class FindRingFragment : Fragment() {
    private var _binding: FragmentFindRingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFindRingBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        val adapter = RingAdapter()
        binding.ringsList.adapter = adapter
        val application = requireNotNull(this.activity).application
        val dao = RingDatabase.getInstance(application).dao
        val viewModelFactory = FindViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(FindViewModel::class.java)


        binding.search.setOnClickListener {
            viewModel.getRingsWithDiameter(binding.ringDiameter.text.toString().toDouble())
                .observe(viewLifecycleOwner, Observer {
                    if (it.isEmpty()) {
                        Toast.makeText(this.context, "С таким диаметром ничего не найдено!", Toast.LENGTH_SHORT).show()
                    } else {
                        adapter.submitList(it)
                    }
                })
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}