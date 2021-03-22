package com.wtt.amz.common.base

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<DB : ViewDataBinding, VM : BaseViewModel>(
    parent: ViewGroup,
    @LayoutRes layoutRes: Int
) : RecyclerView.ViewHolder(DataBindingUtil.inflate<DB>(
        LayoutInflater.from(parent.context),
        layoutRes,
        parent,
        false
    ).root) {
    protected var mDataBinding: DB
        private  set

    protected var mViewModel: VM ?= null

    init {
        mDataBinding = DataBindingUtil.getBinding(itemView)!!

        initViewModel()
        bindViewModel()

        init()
    }

    fun getViewModel() = mViewModel

    /**
     * 初始化ViewModel
     */
    protected abstract fun initViewModel()

    /**
     * 绑定ViewModel
     */
    protected abstract fun bindViewModel()

    /**
     * 初始化
     */
    protected abstract fun init()
}

