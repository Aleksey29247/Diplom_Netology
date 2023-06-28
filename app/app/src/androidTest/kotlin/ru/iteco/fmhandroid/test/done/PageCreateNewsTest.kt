package ru.iteco.fmhandroid.test.done;

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.PagesNewsCreatePageObject

@RunWith(AndroidJUnit4::class)
class PageCreateNewsTest : PagesNewsCreatePageObject() {
    val buttonSave = "save_button"
    val editText = "news_item_title_text_input_edit_text"
    val listTypeNews = "news_item_category_text_auto_complete_text_view"
    val editPublicDateNews = "news_item_publish_date_text_input_edit_text"
    val editPublicTimeNews = "news_item_publish_time_text_input_edit_text"
    val editDescriptText = "news_item_description_text_input_edit_text"
    val buttonOk = "button1"

    @Before
    fun PagesNewsCreate() {
        init()
    }

    @Test
    fun SaveFullPolesTest() {
        waitElementPagesNews(listTypeNews)
        clickElement(listTypeNews)
        waitTextPagesNews("Объявление")
        clickText("Объявление")
        back()
        waitElementPagesNews(editPublicDateNews)
        clickElement(editPublicDateNews)
        waitElementAndroidPagesNew(buttonOk)
        clickElementAndroid(buttonOk)
        waitElementPagesNews(editPublicTimeNews)
        clickElement(editPublicTimeNews)
        waitElementAndroidPagesNew(buttonOk)
        clickElementAndroid(buttonOk)
        waitElementPagesNews(editDescriptText)
        setElement(editDescriptText, "Мы рады")
        clickElement(buttonSave)
        waitTextPagesNews("Объявление")
        assertEquals(seeText("Объявление"), true)

    }

    @Test
    fun SaveFullPolesCategoryTest() {
        waitElementPagesNews(listTypeNews)
        setElement(listTypeNews, "war")
        setElement(editText, "war")
        waitElementPagesNews(editPublicDateNews)
        clickElement(editPublicDateNews)
        waitElementAndroidPagesNew(buttonOk)
        clickElementAndroid(buttonOk)
        waitElementPagesNews(editPublicTimeNews)
        clickElement(editPublicTimeNews)
        waitElementAndroidPagesNew(buttonOk)
        clickElementAndroid(buttonOk)
        waitElementPagesNews(editDescriptText)
        setElement(editDescriptText, "Мы рады")
        clickElement(buttonSave)
        waitTextPagesNews("News")
        assertEquals(seeText("News"), true)
    }

}


