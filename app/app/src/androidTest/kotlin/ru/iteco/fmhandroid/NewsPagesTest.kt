package ru.iteco.fmhandroid;


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import  ru.iteco.fmhandroid.ClassMain

@RunWith(AndroidJUnit4::class)
class NewsPagesTest {
    val cm = ClassMain()
    val buttonMenu = "main_menu_image_button"
    val buttonFilter = "filter_news_material_button"
    val buttonSort = "sort_news_material_button"

    @Before
    fun newsPages() {
        cm.ClassMain()
        cm.getElement(buttonMenu).click()
        cm.waitText("News")
        cm.getText("News").click()
    }

    @Test
    fun sortNewsMaterialButtonTest() {
        cm.getElement(buttonSort).click()
        cm.getElement(buttonSort).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")
    }

    @Test
    fun filterNewsMaterialButtonTest() {
        cm.getElement(buttonFilter).click()
        cm.waitText("Filter news")
        assertEquals(cm.getText("Filter news").text, "Filter news")
    }
}