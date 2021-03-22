package com.wtt.amz.main.view.fragment

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.wtt.amz.R
import com.wtt.amz.common.base.BaseFragment
import com.wtt.amz.common.bean.TitleBean
import com.wtt.amz.databinding.FragmentHomePageBinding
import com.wtt.amz.main.view.adapter.HomePageAdapter
import com.wtt.amz.main.view.vm.HomePageViewModel

private const val DATA = "data"

class HomePageFragment : BaseFragment<FragmentHomePageBinding, HomePageViewModel>() {
    private var data: TitleBean? = null

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home_page
    }

    override fun initViewModel() {
        mViewModel = ViewModelProvider.NewInstanceFactory().create(HomePageViewModel::class.java)
    }

    override fun bindViewModel() {
        mDataBinding.viewmodel = mViewModel
    }

    override fun init() {
        arguments?.let {
            data = it.getParcelable(DATA)
        }
        mViewModel?.mHomePageLiveData?.value = data

        initRecyclerview()
    }

    private  fun initRecyclerview() {
        mDataBinding.rvHomepage.adapter =
            HomePageAdapter(data?.page?.coverList?.toMutableList() ?: mutableListOf())
    }

    companion object {
        @JvmStatic
        fun newInstance(data: TitleBean) =
            HomePageFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(DATA, data)
                }
            }
    }
}