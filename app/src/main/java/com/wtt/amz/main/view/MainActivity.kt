package com.wtt.amz.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.wtt.amz.R
import com.wtt.amz.databinding.ActivityMainBinding
import com.wtt.amz.main.view.fragment.HomeFragment
import com.wtt.amz.main.view.vm.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
            .create(MainViewModel::class.java)
        
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        init()
    }

    private fun init() {
        switchFragment(HOME_FRAGMENT)
    }

    private fun findFragment(tag: String): Fragment {
        return when(tag) {
            HOME_FRAGMENT -> {
                supportFragmentManager.findFragmentByTag(HOME_FRAGMENT) ?: HomeFragment()
            }

            DETAIL_FRAGMENT -> {
                supportFragmentManager.findFragmentByTag(DETAIL_FRAGMENT)!!
            }

            else -> {
                HomeFragment()
            }
        }
    }

    fun switchFragment(tag: String) {
        val fragment = findFragment(tag)

        val transaction = supportFragmentManager.beginTransaction()

        when(tag) {
            HOME_FRAGMENT -> {
                if(!fragment.isAdded) transaction.add(R.id.fl_main,fragment, HOME_FRAGMENT).show(fragment)
            }

            DETAIL_FRAGMENT -> {
                if(!fragment.isAdded) transaction.replace(R.id.fl_main, fragment, DETAIL_FRAGMENT)
            }
        }

        transaction.commitAllowingStateLoss()
    }

    companion object {
        const val HOME_FRAGMENT = "homeFragment"
        const val DETAIL_FRAGMENT = "detailFragment"
    }
}