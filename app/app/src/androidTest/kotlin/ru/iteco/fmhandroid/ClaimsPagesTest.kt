package ru.iteco.fmhandroid;

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ClassMain
import java.util.TimeZone


@RunWith(AndroidJUnit4::class)
class ClaimsPagesTest {

    var cm = ClassMain()
    var buttonOk = "claim_list_filter_ok_material_button"
    var tableClick = "claim_bottom_divider_image_view"

    @Before
    fun pagesAbout() {
        cm.ClassMain()
        cm.getElement("main_menu_image_button").click()
        cm.waitText("Claims")
        cm.getText("Claims").click()
        cm.waitText("Claims")
        cm.getElement("filters_material_button").click()
        cm.waitText("Open")
        cm.getText("Open").click()
        cm.getText("In progress").click()
    }

    @Test
    fun filtersMaterialButtonOpenTest() {
        cm.getText("Open").click()
        cm.getElement(buttonOk).click()
        cm.waitElement("claim_bottom_divider_image_view")
        cm.getElement("claim_bottom_divider_image_view").click()
        cm.waitText("Open")
        assertEquals(cm.getText("Open").text, "Open")
    }

    /*FIXME*/
    @Test
    fun filtersMaterialButtonAllTest() {
        cm.getText("Open").click()
        cm.getText("In progress").click()
        cm.getText("Executed").click()
        cm.getText("Cancelled").click()
        cm.getElement("claim_list_filter_ok_material_button").click()
        cm.waitUpdate(100)
        cm.getElement("claim_bottom_divider_image_view").click()
        cm.waitText("Title")
        cm.getText("Title")
        cm.back();
        cm.waitText("Claims")
        cm.getElement("claim_bottom_divider_image_view").click()
        cm.waitText("Canceled")
        assertEquals(cm.getText("Canceled").text, "Canceled")
    }


    //FIXME

    @Test
    fun filtersMaterialButtontInProgressExecutedCancelledTest() {
        cm.getText("In progress").click()
        cm.getText("Executed").click()
        cm.getText("Cancelled").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("In progress")
        assertEquals(cm.getText("In progress").text, "In progress")
    }

    ///FIXME
    @Test
    fun filtersMaterialButtontOpenExecutedCancelledTest() {
        cm.getText("Open").click()
        cm.getText("Executed").click()
        cm.getText("Cancelled").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("Title")
        cm.getText("Title")
        cm.back();
        cm.waitText("Claims")
        cm.getElement(tableClick).click()
        cm.waitText("Canceled")
        assertEquals(cm.getText("Canceled").text, "Canceled")
    }

    @Test
    fun filtersMaterialButtontOpenInProgressCancelled() {

        cm.getText("Open").click()
        cm.getText("In progress").click()
        cm.getText("Cancelled").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("Canceled")
        assertEquals(cm.getText("Canceled").text, "Canceled")
    }

    @Test
    fun filtersMaterialButtontOpenInProgressExecutedTest() {
        cm.getText("Open").click()
        cm.getText("In progress").click()
        cm.getText("Executed").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("Executed")
        assertEquals(cm.getText("Executed").text, "Executed")
    }

    @Test
    fun filtersMaterialButtontExecutedCanceledTest() {
        cm.getText("Cancelled").click()
        cm.getText("Executed").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("Title")
        cm.getText("Title")
        cm.back();
        cm.waitText("Claims")
        cm.getElement(tableClick).click()
        cm.waitText("Canceled")
        assertEquals(cm.getText("Canceled").text, "Canceled")
    }

    @Test
    fun filtersMaterialButtontOpenInProgressTest() {
        cm.getText("Open").click()
        cm.getText("In progress").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("In progress")
        assertEquals(cm.getText("In progress").text, "In progress")
    }

    // FIXME:
    @Test
    fun filtersMaterialButtontOpenExecutedTest() {
        cm.getText("Open").click()
        cm.getText("Executed").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("Executed")
        assertEquals(cm.getText("Executed").text, "Executed")
    }

    @Test
    fun filtersMaterialButtontOpenCanceledTest() {
        cm.getText("Open").click()
        cm.getText("Cancelled").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("Canceled")
        assertEquals(cm.getText("Canceled").text, "Canceled")
    }

    @Test
    fun filtersMaterialButtontInProgressExecutedTest() {
        cm.getText("In progress").click()
        cm.getText("Executed").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("Executed")
        assertEquals(cm.getText("Executed").text, "Executed")
    }

    @Test
    fun filtersMaterialButtontInProgressCanceledTest() {
        cm.getText("In progress").click()
        cm.getText("Cancelled").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("In progress")
        assertEquals(cm.getText("In progress").text, "In progress")
    }

    @Test
    fun filtersMaterialButtontCanceledTest() {
        cm.getText("Cancelled").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("Canceled")
        assertEquals(cm.getText("Canceled").text, "Canceled")
    }

    @Test
    fun filtersMaterialButtontInProgressTest() {
        cm.getText("In progress").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("In progress")
        assertEquals(cm.getText("In progress").text, "In progress")
    }

    @Test
    fun filtersMaterialButtontExecutedTest() {
        cm.getText("Executed").click()
        cm.getElement(buttonOk).click()
        cm.waitElement(tableClick)
        cm.getElement(tableClick).click()
        cm.waitText("Executed")
        assertEquals(cm.getText("Executed").text, "Executed")
    }

    @Test
    fun filtersMaterialButtontNullTest() {
        cm.getElement(buttonOk).click()
        cm.waitText("REFRESH")
        assertEquals(cm.getText("REFRESH").text, "REFRESH")
    }
}

