package com.wtt.amz.main.view.fragment

import androidx.lifecycle.ViewModelProvider
import com.wtt.amz.R
import com.wtt.amz.common.base.BaseFragment
import com.wtt.amz.databinding.FragmentHomeBinding
import com.wtt.amz.main.view.adapter.VPHomeAdapter
import com.wtt.amz.main.view.vm.HomeViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initViewModel() {
        mViewModel = ViewModelProvider.NewInstanceFactory().create(HomeViewModel::class.java)
    }

    override fun bindViewModel() {
        mDataBinding.viewModel = mViewModel
    }

    override fun init() {
        mDataBinding.tlHomeDisplay.setupWithViewPager(mDataBinding.vpHomeDisplay)

        mViewModel?.liveDataMainPage?.observe(
            this,
            {
                mDataBinding.vpHomeDisplay.adapter =
                    VPHomeAdapter(it.titleList, parentFragmentManager)
            }
        )
    }

}