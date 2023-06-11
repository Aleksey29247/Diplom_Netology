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
class ClaimsPagesTest : ClassMain() {


    var buttonOk = "claim_list_filter_ok_material_button"
    var tableClick = "claim_bottom_divider_image_view"

    @Before
    fun pagesAbout() {
        ClassMain()
        getElement("main_menu_image_button").click()
        waitText("Claims")
        getText("Claims").click()
        waitText("Claims")
        getElement("filters_material_button").click()
        waitText("Open")
        getText("Open").click()
        getText("In progress").click()
    }

    @Test
    fun filtersMaterialButtonOpenTest() {
        getText("Open").click()
        getElement(buttonOk).click()
        waitElement("claim_bottom_divider_image_view")
        getElement("claim_bottom_divider_image_view").click()
        waitText("Open")
        assertEquals(getText("Open").text, "Open")
    }

    /*FIXME*/
    @Test
    fun filtersMaterialButtonAllTest() {
        getText("Open").click()
        getText("In progress").click()
        getText("Executed").click()
        getText("Cancelled").click()
        getElement("claim_list_filter_ok_material_button").click()
        waitUpdate(100)
        getElement("claim_bottom_divider_image_view").click()
        waitText("Title")
        getText("Title")
        back();
        waitText("Claims")
        getElement("claim_bottom_divider_image_view").click()
        waitText("Canceled")
        assertEquals(getText("Canceled").text, "Canceled")
    }

      @Test
    fun filtersMaterialButtontInProgressExecutedCancelledTest() {
        getText("In progress").click()
        getText("Executed").click()
        getText("Cancelled").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("In progress")
        assertEquals(getText("In progress").text, "In progress")
    }

      @Test
    fun filtersMaterialButtontOpenExecutedCancelledTest() {
        getText("Open").click()
        getText("Executed").click()
        getText("Cancelled").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("Title")
        getText("Title")
        back();
        waitText("Claims")
        getElement(tableClick).click()
        waitText("Canceled")
        assertEquals(getText("Canceled").text, "Canceled")
    }

    @Test
    fun filtersMaterialButtontOpenInProgressCancelled() {

        getText("Open").click()
        getText("In progress").click()
        getText("Cancelled").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("Canceled")
        assertEquals(getText("Canceled").text, "Canceled")
    }

    @Test
    fun filtersMaterialButtontOpenInProgressExecutedTest() {
        getText("Open").click()
        getText("In progress").click()
        getText("Executed").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("Executed")
        assertEquals(getText("Executed").text, "Executed")
    }

    @Test
    fun filtersMaterialButtontExecutedCanceledTest() {
        getText("Cancelled").click()
        getText("Executed").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("Title")
        getText("Title")
        back();
        waitText("Claims")
        getElement(tableClick).click()
        waitText("Canceled")
        assertEquals(getText("Canceled").text, "Canceled")
    }

    @Test
    fun filtersMaterialButtontOpenInProgressTest() {
        getText("Open").click()
        getText("In progress").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("In progress")
        assertEquals(getText("In progress").text, "In progress")
    }

    @Test
    fun filtersMaterialButtontOpenExecutedTest() {
        getText("Open").click()
        getText("Executed").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("Executed")
        assertEquals(getText("Executed").text, "Executed")
    }

    @Test
    fun filtersMaterialButtontOpenCanceledTest() {
        getText("Open").click()
        getText("Cancelled").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("Canceled")
        assertEquals(getText("Canceled").text, "Canceled")
    }

    @Test
    fun filtersMaterialButtontInProgressExecutedTest() {
        getText("In progress").click()
        getText("Executed").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("Executed")
        assertEquals(getText("Executed").text, "Executed")
    }

    @Test
    fun filtersMaterialButtontInProgressCanceledTest() {
        getText("In progress").click()
        getText("Cancelled").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("In progress")
        assertEquals(getText("In progress").text, "In progress")
    }

    @Test
    fun filtersMaterialButtontCanceledTest() {
        getText("Cancelled").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("Canceled")
        assertEquals(getText("Canceled").text, "Canceled")
    }

    @Test
    fun filtersMaterialButtontInProgressTest() {
        getText("In progress").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("In progress")
        assertEquals(getText("In progress").text, "In progress")
    }

    @Test
    fun filtersMaterialButtontExecutedTest() {
        getText("Executed").click()
        getElement(buttonOk).click()
        waitElement(tableClick)
        getElement(tableClick).click()
        waitText("Executed")
        assertEquals(getText("Executed").text, "Executed")
    }

    @Test
    fun filtersMaterialButtontNullTest() {
        getElement(buttonOk).click()
        waitText("REFRESH")
        assertEquals(getText("REFRESH").text, "REFRESH")
    }
}

