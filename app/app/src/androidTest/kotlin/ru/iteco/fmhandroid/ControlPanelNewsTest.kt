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
class ControlPanelNewsTest {
    val cm = ClassMain()
    val buttonMenu = "main_menu_image_button"
    val buttonNews = "edit_news_material_button"
    val buttonSort = "sort_news_material_button"
    val buttonFilterSet = "filter_button"
    val buttonFilter = "filter_news_material_button"

    @Before
    fun pagesControlPanel() {
        cm.ClassMain()
        cm.getElement(buttonMenu).click()
        cm.waitText("News")
        cm.getText("News").click()
        cm.waitElement(buttonNews)
        cm.getElement(buttonNews).click()
        cm.waitText("ACTIVE")
    }

    @Test
    fun sortNewsMaterialButtonZXYTest() {
        cm.getElement(buttonSort).click()
        cm.getElement(buttonSort).click()
        cm.waitText("ACTIVE")
        assertEquals(cm.getText("ACTIVE").text, "ACTIVE")
    }

    @Test
    fun filterNewsMaterialButtonTest() {
        cm.getElement(buttonFilter).click()
        cm.waitText("Active")
        cm.getText("Active").click()
        cm.getText("Not active").click()
        cm.getElement(buttonFilterSet).click()
        cm.waitText("ACTIVE")
        assertEquals(cm.getText("ACTIVE").text, "ACTIVE")
    }
}