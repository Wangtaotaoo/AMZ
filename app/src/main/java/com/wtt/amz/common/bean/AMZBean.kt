package com.wtt.amz.common.bean

data class AMZBean(
    var titleList: List<TitleBean>,
    var coverList: List<CoverBean>,
    var page: PageModel
)

data class TitleBean(
    var title: String,
    var herf: String
)

data class CoverBean(
    var detailUrl: String,
    var coverUrl: String,
    var width: Int,
    var height: Int
)

data class PageModel(
    var currentPage: Int,
    var totalPage: Int
)