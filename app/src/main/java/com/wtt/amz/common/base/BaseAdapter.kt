package com.wtt.amz.common.base

import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VH: RecyclerView.ViewHolder>(val mDataList: List<Any>): RecyclerView.Adapter<VH>() {

    override fun getItemCount(): Int {
        return mDataList.size
    }


}