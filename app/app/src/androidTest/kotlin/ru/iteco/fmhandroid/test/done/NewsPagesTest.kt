package ru.iteco.fmhandroid.test.done;


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.NewsPagesPageObject

@RunWith(AndroidJUnit4::class)
class NewsPagesTest : NewsPagesPageObject() {
    val buttonFilter = "filter_news_material_button"
    val buttonSort = "sort_news_material_button"

    @Before
    fun newsPages() {
        init()
    }

    @Test
    fun sortNewsMaterialButtonTest() {
        clickElement(buttonSort)
        clickElement(buttonSort)
        waitTextNewsPages("News")
        assertEquals(seeText("News"), true)
    }

    @Test
    fun filterNewsMaterialButtonTest() {
        clickElement(buttonFilter)
        waitTextNewsPages("Filter news")
        assertEquals(seeText("Filter news"), true)
    }
}