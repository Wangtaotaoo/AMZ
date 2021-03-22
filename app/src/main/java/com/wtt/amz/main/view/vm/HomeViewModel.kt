package com.wtt.amz.main.view.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wtt.amz.common.base.BaseViewModel
import com.wtt.amz.common.bean.AMZBean
import com.wtt.amz.common.net.NetClient
import com.wtt.amz.common.util.ParseHelper
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel() {
    private val _liveDataMain: MutableLiveData<AMZBean> by lazy {
        MutableLiveData()
    }

    val liveDataMainPage = _liveDataMain

    init {
        viewModelScope.launch {
            val result = NetClient.getInstance().listPage(0)
            _liveDataMain.value = ParseHelper.parseMainPage(result.string())
        }



    }





}