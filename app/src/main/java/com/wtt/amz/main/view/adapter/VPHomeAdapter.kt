package com.wtt.amz.main.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.PagerAdapter
import com.wtt.amz.R
import com.wtt.amz.common.bean.TitleBean
import com.wtt.amz.databinding.HomeItemBinding
import com.wtt.amz.main.view.fragment.HomePageFragment

class VPHomeAdapter(var dataList: List<TitleBean> ?= null, fm: FragmentManager): FragmentStatePagerAdapter(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return dataList?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return dataList?.get(position)?.title
    }

    override fun getItem(position: Int): Fragment {
        val fragment = dataList?.get(position)?.let { HomePageFragment.newInstance(it) }
        return fragment ?: HomePageFragment()
    }
}