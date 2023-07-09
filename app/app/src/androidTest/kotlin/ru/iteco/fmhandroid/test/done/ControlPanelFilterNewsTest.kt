package ru.iteco.fmhandroid.test.done;


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ControlPanelPageObject

@RunWith(AllureAndroidJUnit4::class)
class ControlPanelFilterNewsTest : ControlPanelPageObject() {

    val buttonFilterSet = "filter_button"
    val editDataBegin = "news_item_publish_date_start_text_input_edit_text"
    val editDataEnd = "news_item_publish_date_end_text_input_edit_text"
    val buttonOk = "button1"

    @Before
    fun pagesControlPanelFilter() {
        init()
    }

    @Test
    fun categoryWerNotData() {
        setTextElement("Category", "wer")
        clickElement(buttonFilterSet)
        controlPanelWaitText("Control panel")
        assertEquals(textSee("Control panel"), true)
    }

    @Test
    fun dateErrorTest() {
        setTextElement("Category", "wer")
        setElementText(editDataBegin, "war")
        clickElement(buttonFilterSet)
        controlPanelWaitText("Wrong period")
        assertEquals(textSee("Wrong period"), true)

    }

    @Test
    fun normalDataOneTest() {
        setTextElement("Category", "wer")
        clickElement(editDataBegin)
        controlPanelWaitElementAndroid(buttonOk)
        clickElementAndroid(buttonOk)
        clickElement(buttonFilterSet)
        controlPanelWaitText("Wrong period")
        assertEquals(textSee("Wrong period"), true)

    }

    @Test
    fun normalDataTwoTest() {
        setTextElement("Category", "wer")
        clickElement(editDataBegin)
        controlPanelWaitElementAndroid(buttonOk)
        clickElementAndroid(buttonOk)
        clickElement(editDataEnd)
        controlPanelWaitElementAndroid(buttonOk)
        clickElementAndroid(buttonOk)
        waitElement(buttonFilterSet)
        clickElement(buttonFilterSet)
        controlPanelWaitText("Control panel")
        assertEquals(textSee("Control panel"), true)

    }

    @Test
    fun activeFalseNotActiverTrueTest() {
        clickText("Not active")
        clickElement(buttonFilterSet)
        controlPanelWaitText("NOT ACTIVE")
        assertEquals(textSee("NOT ACTIVE"), true)


    }
}