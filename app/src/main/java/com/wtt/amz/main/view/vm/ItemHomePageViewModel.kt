package com.wtt.amz.main.view.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wtt.amz.common.base.BaseViewModel
import com.wtt.amz.common.bean.CoverBean

class ItemHomePageViewModel: BaseViewModel() {
    var mItemLiveData = MutableLiveData<CoverBean>()
        private set

    fun setData(coverBean: CoverBean) {
        mItemLiveData.value = coverBean
    }

}