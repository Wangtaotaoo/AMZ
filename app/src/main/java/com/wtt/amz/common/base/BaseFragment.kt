package com.wtt.amz.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    lateinit var mDataBinding: DB

    var mViewModel: VM? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        mViewModel?.run { lifecycle.addObserver(this) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate(
            inflater, getLayoutResId(),
            container, false
        )

        bindViewModel()
        init()
        mDataBinding.lifecycleOwner = this  //不加他娘的界面不自动刷新
        return mDataBinding.root
    }

    abstract fun getLayoutResId(): Int

    abstract fun initViewModel()

    abstract fun bindViewModel()

    abstract fun init()
}