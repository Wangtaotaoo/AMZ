package com.wtt.amz.main.view_model

import android.app.Application
import androidx.lifecycle.*
import com.wtt.amz.common.bean.AMZBean
import com.wtt.amz.common.net.NetClient
import com.wtt.amz.common.util.ParseHelper
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    val liveDataMain: MutableLiveData<AMZBean>  by lazy {
        MutableLiveData()
    }


    init {
        viewModelScope.launch {
            val result = NetClient.getInstance().listPage(0)
//            liveDataMain.value = ParseHelper.parseMainPage(result.string())
        }
    }

}