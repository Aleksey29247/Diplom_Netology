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
class MainPagesTest {
    val cm = ClassMain()
    val buttonMenu = "expand_material_button"
    val buttonAllNews = "all_news_text_view"

    @Before
    fun pageMain() {
        cm.ClassMain()
    }

    @Test
    fun stringNewsTest() {
        cm.getText("News").click()

    }

    @Test
    fun expandMaterialButtonUpDownTest() {
        cm.getElement(buttonMenu).click()
        cm.waitElement(buttonMenu)
        cm.getElement(buttonMenu).click()
        cm.waitText("ALL NEWS")
        assertEquals(cm.getText("ALL NEWS").text, "ALL NEWS")
    }

    @Test
    fun allNewsTextViewTest() {
        cm.getElement(buttonAllNews).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")
    }
}