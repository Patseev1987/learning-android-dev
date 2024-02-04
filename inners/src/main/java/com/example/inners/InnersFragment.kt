package com.example.inners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.inners.data.PersonDatabase
import com.example.inners.databinding.FragmentInnersBinding
import com.example.inners.modelView.PersonModelView
import com.example.inners.modelView.PersonViewModelFactory


class InnersFragment : Fragment() {


    var _binding:FragmentInnersBinding? = null
    val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInnersBinding.inflate(inflater,container,false)
        val view = binding.root
        val application = requireNotNull(this.activity).application
        val dao = PersonDatabase.getInstance(application).dao
        val personViewModelFactory = PersonViewModelFactory(dao)
        val viewModel = ViewModelProvider(this,personViewModelFactory).get(PersonModelView::class.java)
        viewModel.peopleString.observe(viewLifecycleOwner, Observer {
            binding.people.text = it
        })
        binding.addPerson.setOnClickListener {
            val name = binding.name.text.toString()
            val lastname = binding.lastName.text.toString()
            val age = binding.age.text.toString().toInt()
            viewModel.add(name = name,lastname = lastname,age = age)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}