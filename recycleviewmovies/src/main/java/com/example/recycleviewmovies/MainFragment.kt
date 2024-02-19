package com.example.recycleviewmovies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recycleviewmovies.apiRetrofit.ApiFactory
import com.example.recycleviewmovies.databinding.FragmentMainBinding
import com.example.recycleviewmovies.recycleView.MoviesAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class MainFragment : Fragment() {
    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val TAG:String = "Bogdan"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val view = binding.root
        val adapter = MoviesAdapter()
        ApiFactory.apiService.loadMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
            { Log.d(TAG, it.toString())
            adapter.movies = it.movies},
            {Log.d(TAG,it.toString())}
        )
        binding.recycleViewMovies.adapter = adapter

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}