package com.wtt.amz.common.util

import com.google.gson.internal.bind.DateTypeAdapter
import com.wtt.amz.common.bean.AMZBean
import com.wtt.amz.common.bean.CoverBean
import com.wtt.amz.common.bean.PageModel
import com.wtt.amz.common.bean.TitleBean
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

object ParseHelper {


    fun parseMainPage(data: String): AMZBean {
        return AMZBean(parseTitleBean(data))
    }

    fun parseTitleBean(data: String): List<TitleBean>{
        val multiList = mutableListOf<TitleBean>()

        val doc = Jsoup.parse(data)
        val titles = doc.select("[id=menu-nav]")
            .select("li")

        for( i in titles) {
            val title = i.text()
            val link = i.select("a").attr("href")
            multiList.add(TitleBean(title, link, parsePage(doc)))
        }
        return multiList
    }

    fun parsePage(doc: Document): PageModel {
        val page = doc.select(".nav-links")
        val pageCurrent =    page.select("[aria-current]").text()
        val pageTotal =  page.select("[class = page-numbers]").last().text()
        val pageNextHref = page.select("[class = next page-numbers]").attr("href")

        return  PageModel(pageCurrent.toInt(), pageTotal.toInt(), pageNextHref , parseCoveList(doc))
    }

    fun parseCoveList(doc: Document): List<CoverBean> {
        val coverList = mutableListOf<CoverBean>()

        val covers = doc.select("[id=pins]").select("li")
        for(i in covers) {
            val refLink = i.select("a").attr("href")
            val coverImg = i.select("img").attr("data-original")
            val width = i.select("img").attr("width")
            val height = i.select("img").attr("height")
            val alt = i.select("img").attr("alt")

            coverList.add(CoverBean(refLink, coverImg, width.toInt(),height.toInt()))
        }
        return coverList
    }


}