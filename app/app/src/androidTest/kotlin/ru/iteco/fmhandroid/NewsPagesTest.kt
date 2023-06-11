package ru.iteco.fmhandroid;


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import  ru.iteco.fmhandroid.ClassMain

@RunWith(AndroidJUnit4::class)
class NewsPagesTest : ClassMain(){
    val buttonMenu = "main_menu_image_button"
    val buttonFilter = "filter_news_material_button"
    val buttonSort = "sort_news_material_button"

    @Before
    fun newsPages() {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
    }

    @Test
    fun sortNewsMaterialButtonTest() {
        getElement(buttonSort).click()
        getElement(buttonSort).click()
        waitText("News")
        assertEquals(getText("News").text, "News")
    }

    @Test
    fun filterNewsMaterialButtonTest() {
        getElement(buttonFilter).click()
        waitText("Filter news")
        assertEquals(getText("Filter news").text, "Filter news")
    }
}