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
class ControlPanelNewsTest : ClassMain(){
    val buttonMenu = "main_menu_image_button"
    val buttonNews = "edit_news_material_button"
    val buttonSort = "sort_news_material_button"
    val buttonFilterSet = "filter_button"
    val buttonFilter = "filter_news_material_button"

    @Before
    fun pagesControlPanel() {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
        waitElement(buttonNews)
        getElement(buttonNews).click()
        waitText("ACTIVE")
    }

    @Test
    fun sortNewsMaterialButtonZXYTest() {
        getElement(buttonSort).click()
        getElement(buttonSort).click()
        waitText("ACTIVE")
        assertEquals(getText("ACTIVE").text, "ACTIVE")
    }

    @Test
    fun filterNewsMaterialButtonTest() {
        getElement(buttonFilter).click()
        waitText("Active")
        getText("Active").click()
        getText("Not active").click()
        getElement(buttonFilterSet).click()
        waitText("ACTIVE")
        assertEquals(getText("ACTIVE").text, "ACTIVE")
    }
}