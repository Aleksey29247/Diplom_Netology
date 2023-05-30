package ru.iteco.fmhandroid;
//ok

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import  ru.iteco.fmhandroid.ClassMain

@RunWith(AndroidJUnit4::class)
class ControlPanelFilterNewsTest {

    val buttonMenu = "main_menu_image_button"
    val buttonNews = "edit_news_material_button"
    val buttonFilter = "filter_news_material_button"
    val buttonFilterSet = "filter_button"
    val editDataBegin = "news_item_publish_date_start_text_input_edit_text"
    val editDataEnd = "news_item_publish_date_end_text_input_edit_text"
    val buttonOk = "button1"
    var cm = ClassMain()

    @Before
    fun pagesControlPanelFilter() {
        cm.ClassMain()
        cm.getElement(buttonMenu).click()
        cm.waitText("News")
        cm.getText("News").click()
        cm.waitElement(buttonNews)
        cm.getElement(buttonNews).click()
        cm.waitElement(buttonFilter)
        cm.getElement(buttonFilter).click()
        cm.waitText("Active")
        cm.getText("Active").click()
        cm.getText("Not active").click()
    }

    @Test
    fun categoryWerNotData() {
        cm.getText("Category").setText("wer")
        cm.getElement(buttonFilterSet).click()
        cm.waitText("Control panel")
        assertEquals(cm.getText("Control panel").text, "Control panel")
    }

    @Test
    fun dateErrorTest() {
        cm.getText("Category").setText("wer")
        cm.getElement(editDataBegin).text = "war"
        cm.getElement(buttonFilterSet).click()
        cm.waitText("Wrong period")
        assertEquals(cm.getText("Wrong period").text, "Wrong period")
    }

    @Test
    fun normalDataOneTest() {
        cm.getText("Category").setText("wer")
        cm.getElement(editDataBegin).click()
        cm.waitElementAndroid(buttonOk)
        cm.getElementAndroid(buttonOk).click()
        cm.waitElement(buttonFilterSet)
        cm.getElement(buttonFilterSet).click()
        cm.waitText("Wrong period")
        assertEquals(cm.getText("Wrong period").text, "Wrong period")
    }

    @Test
    fun normalDataTwoTest() {
        cm.getText("Category").setText("wer")
        cm.getElement(editDataBegin).click()
        cm.waitElementAndroid(buttonOk)
        cm.getElementAndroid(buttonOk).click()
        cm.waitElement(buttonFilterSet)
        cm.getElement(editDataEnd).click()
        cm.waitElementAndroid(buttonOk)
        cm.getElementAndroid(buttonOk).click()
        cm.waitElement(buttonFilterSet)
        cm.getElement(buttonFilterSet).click()
        cm.waitText("Control panel")
        assertEquals(cm.getText("Control panel").text, "Control panel")
    }

    @Test
    fun activeFalseNotActiverTrueTest() {
        cm.getText("Not active").click()
        cm.getElement(buttonFilterSet).click()
        cm.waitText("NOT ACTIVE")
        assertEquals(cm.getText("NOT ACTIVE").text, "NOT ACTIVE")
    }
}