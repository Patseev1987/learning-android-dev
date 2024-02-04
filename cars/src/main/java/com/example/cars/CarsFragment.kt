package com.example.cars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cars.data.CarsDatabase
import com.example.cars.databinding.FragmentCarsBinding
import com.example.cars.viewModel.CarsViewModel
import com.example.cars.viewModel.CarsViewModelFabrica


class CarsFragment : Fragment() {
   private var _binding:FragmentCarsBinding? = null
  private  val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCarsBinding.inflate(inflater,container,false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = CarsDatabase.getInstance(application).carDao
        val viewModelFabrica = CarsViewModelFabrica(dao)
        val viewModel = ViewModelProvider(this,viewModelFabrica).get(CarsViewModel::class.java)


        binding.addCar.setOnClickListener {
            val model = binding.model.text.toString()
            val year = binding.year.text.toString().toInt()
            val color = binding.Color.text.toString()
            viewModel.addCar(model,year,color)
        }


        viewModel.carsString.observe(viewLifecycleOwner, Observer {
            binding.cars.text = it
        })


        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}