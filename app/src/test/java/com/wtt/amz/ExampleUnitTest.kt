package com.wtt.amz

import android.util.Log
import org.jsoup.Jsoup
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun parseTitles() {
        val doc = Jsoup.connect("https://www.mzitu.com/").get()
        val titles = doc.select("[id=menu-nav]")
            .select("li")
//        println(titles)
        for(i in titles) {
            val title = i.text()
            val link = i.select("a").attr("href")
            println(title)
            println(link)
        }
    }

    @Test
    fun parseCover() {
        val doc = Jsoup.connect("https://www.mzitu.com/")
            .header("User-Agent","Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.93 Safari/537.36").get()
        val covers = doc.select("[id=pins]").select("li")
        for(i in covers) {
            val refLink = i.select("a").attr("href")
            val coverImg = i.select("img").attr("data-original")
            val width = i.select("img").attr("width")
            val height = i.select("img").attr("height")
            val alt = i.select("img").attr("alt")
            println(alt)
        }
    }

    @Test
    fun parsePage() {
        val doc = Jsoup.connect("https://www.mzitu.com/")
            .header("User-Agent","Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.93 Safari/537.36").get()
        val page = doc.select(".nav-links")
        val pageCurrent =    page.select("[aria-current]").text()
        val pageTotal =  page.select("[class = page-numbers]").last().text()
        val pageNextHref = page.select("[class = next page-numbers]").attr("href")
        println(pageNextHref )
    }


//    @Test
//    fun parseTitles() {
//        val doc = Jsoup.connect("https://www.mzitu.com/")
//            .header("User-Agent","Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.93 Safari/537.36").get()
//        val page = doc.select(".nav-links")
//        val pageCurrent =    page.select("[aria-current]").text()
//        val pageTotal =  page.select("[class = page-numbers]").last().text()
//        val pageNextHref = page.select("[class = next page-numbers]").attr("href")
//        println(pageNextHref )
//    }


}