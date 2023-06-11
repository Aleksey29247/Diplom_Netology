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
class ControlPanelFilterNewsTest : ClassMain(){

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
        ClassMain()
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
        waitElement(buttonNews)
        getElement(buttonNews).click()
        waitElement(buttonFilter)
        getElement(buttonFilter).click()
        waitText("Active")
        getText("Active").click()
        getText("Not active").click()
    }

    @Test
    fun categoryWerNotData() {
        getText("Category").setText("wer")
        getElement(buttonFilterSet).click()
        waitText("Control panel")
        assertEquals(getText("Control panel").text, "Control panel")
    }

    @Test
    fun dateErrorTest() {
        getText("Category").setText("wer")
        getElement(editDataBegin).text = "war"
        getElement(buttonFilterSet).click()
        waitText("Wrong period")
        assertEquals(getText("Wrong period").text, "Wrong period")
    }

    @Test
    fun normalDataOneTest() {
        getText("Category").setText("wer")
        getElement(editDataBegin).click()
        waitElementAndroid(buttonOk)
        getElementAndroid(buttonOk).click()
        waitElement(buttonFilterSet)
        getElement(buttonFilterSet).click()
        waitText("Wrong period")
        assertEquals(getText("Wrong period").text, "Wrong period")
    }

    @Test
    fun normalDataTwoTest() {
        getText("Category").setText("wer")
        getElement(editDataBegin).click()
        waitElementAndroid(buttonOk)
        getElementAndroid(buttonOk).click()
        waitElement(buttonFilterSet)
        getElement(editDataEnd).click()
        waitElementAndroid(buttonOk)
        getElementAndroid(buttonOk).click()
        waitElement(buttonFilterSet)
        getElement(buttonFilterSet).click()
        waitText("Control panel")
        assertEquals(getText("Control panel").text, "Control panel")
    }

    @Test
    fun activeFalseNotActiverTrueTest() {
        getText("Not active").click()
        getElement(buttonFilterSet).click()
        waitText("NOT ACTIVE")
        assertEquals(getText("NOT ACTIVE").text, "NOT ACTIVE")
    }
}