package com.example.dogs

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var image: ImageView
    private lateinit var buttonNext: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getDogImage()
        viewModel.dogImage.observe(this, Observer {
            Glide.with(this)
                .load(it.message)
                .into(image)
        })

        viewModel.isLoading.observe(this, Observer {
            if (it) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        })

        buttonNext.setOnClickListener {
            viewModel.getDogImage()
        }


    }

   private fun initViews() {
        image = findViewById(R.id.imageView)
        buttonNext = findViewById(R.id.buttonNext)
        progressBar = findViewById(R.id.progressBar)
    }
}