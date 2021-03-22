package com.wtt.amz.main.view.vm

import androidx.lifecycle.MutableLiveData
import com.wtt.amz.common.base.BaseViewModel
import com.wtt.amz.common.bean.TitleBean

class HomePageViewModel : BaseViewModel() {
    private val _homePageLiveData: MutableLiveData<TitleBean> by lazy {
        MutableLiveData()
    }

    var mHomePageLiveData = _homePageLiveData
}