package com.wtt.amz.main.view.viewholder

import android.view.ViewGroup
import com.wtt.amz.R
import com.wtt.amz.common.base.BaseViewHolder
import com.wtt.amz.databinding.ItemHomePageBinding
import com.wtt.amz.main.view.vm.ItemHomePageViewModel

class HomeViewHolder(parent: ViewGroup) : BaseViewHolder<ItemHomePageBinding , ItemHomePageViewModel>(parent, R.layout.item_home_page) {
    override fun initViewModel() {
        mViewModel = ItemHomePageViewModel()
    }

    override fun bindViewModel() {
        mDataBinding.viewModel = mViewModel
    }

    override fun init() {

    }
}