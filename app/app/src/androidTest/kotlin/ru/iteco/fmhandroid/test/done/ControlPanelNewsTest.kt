package ru.iteco.fmhandroid.test.done;


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ControlPanelNewPageObject

@RunWith(AllureAndroidJUnit4::class)
class ControlPanelNewsTest : ControlPanelNewPageObject() {


    val buttonSort = "sort_news_material_button"
    val buttonFilterSet = "filter_button"
    val buttonFilter = "filter_news_material_button"

    @Before
    fun pagesControlPanel() {
        init()
    }

    @Test
    fun sortNewsMaterialButtonZXYTest() {
        clickElement(buttonSort)
        conrolPanelNewWaitText("ACTIVE")
        assertEquals(textSee("ACTIVE"), true)
    }

    @Test
    fun filterNewsMaterialButtonTest() {
        controlPanelNewWaitElement(buttonFilter)
        clickElement(buttonFilter)
        conrolPanelNewWaitText("Active")
        clickText("Active")
        clickText("Not active")
        clickElement(buttonFilterSet)
        conrolPanelNewWaitText("ACTIVE")
        assertEquals(textSee("ACTIVE"), true)
    }
}