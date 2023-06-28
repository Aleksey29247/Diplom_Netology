package ru.iteco.fmhandroid.test.done;

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.MainPagesPageObject

@RunWith(AndroidJUnit4::class)
class MainPagesTest : MainPagesPageObject() {
    val buttonMenu = "expand_material_button"
    val buttonAllNews = "all_news_text_view"

    @Before
    fun pageMain() {
        ClassMain()
    }

    @Test
    fun expandMaterialButtonUpDownTest() {
        clickElement(buttonMenu)
        waitElementMainPages(buttonMenu)
        clickElement(buttonMenu)
        waitTextMainPages("ALL NEWS")
        assertEquals(seeText("ALL NEWS"), true)
    }

    @Test
    fun allNewsTextViewTest() {
        clickElement(buttonAllNews)
        waitTextMainPages("News")
        assertEquals(seeText("News"), true)
    }
}