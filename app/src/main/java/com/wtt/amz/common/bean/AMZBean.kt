package com.wtt.amz.common.bean

import android.os.Parcelable
import androidx.databinding.Bindable
import androidx.databinding.ObservableList
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class AMZBean(
    var titleList: List<TitleBean>
): Parcelable

@Parcelize
data class TitleBean(
    var title: String,
    var herf: String,
    var page: PageModel
): Parcelable

@Parcelize
data class PageModel(
    var currentPage: Int,
    var totalPage: Int,
    var nextPageHref: String,
    var coverList: List<CoverBean>
): Parcelable

@Parcelize
data class CoverBean(
    var detailUrl: String,
    var coverUrl: String,
    var width: Int,
    var height: Int
): Parcelable