package com.wtt.amz.common.base

import androidx.databinding.BaseObservable
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel(), LifecycleObserver {
}