package com.wtt.amz.main.view.adapter

import android.view.ViewGroup
import com.wtt.amz.common.base.BaseAdapter
import com.wtt.amz.common.bean.CoverBean
import com.wtt.amz.common.bean.PageModel
import com.wtt.amz.main.view.viewholder.HomeViewHolder

class HomePageAdapter(data: MutableList<CoverBean>): BaseAdapter<HomeViewHolder>(data) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val data = mDataList[position]
        (holder).getViewModel()?.setData(data as CoverBean)
    }
}