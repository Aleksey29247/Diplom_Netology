package ru.iteco.fmhandroid;
///ok

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ClassMain

@RunWith(AndroidJUnit4::class)
class MainPagesTest : ClassMain(){
    val buttonMenu = "expand_material_button"
    val buttonAllNews = "all_news_text_view"

    @Before
    fun pageMain() {
        ClassMain()
    }

    @Test
    fun stringNewsTest() {
        getText("News").click()

    }

    @Test
    fun expandMaterialButtonUpDownTest() {
        getElement(buttonMenu).click()
        waitElement(buttonMenu)
        getElement(buttonMenu).click()
        waitText("ALL NEWS")
        assertEquals(getText("ALL NEWS").text, "ALL NEWS")
    }

    @Test
    fun allNewsTextViewTest() {
        getElement(buttonAllNews).click()
        waitText("News")
        assertEquals(getText("News").text, "News")
    }
}