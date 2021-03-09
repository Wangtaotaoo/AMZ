package com.wtt.amz.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.wtt.amz.R
import com.wtt.amz.databinding.ActivityMainBinding
import com.wtt.amz.main.view_model.MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
            .create(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}