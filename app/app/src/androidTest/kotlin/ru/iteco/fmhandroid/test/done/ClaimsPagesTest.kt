package ru.iteco.fmhandroid.test.done;

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ClaimsPages


@RunWith(AllureAndroidJUnit4::class)
class ClaimsPagesTest : ClaimsPages() {


    var buttonOk = "claim_list_filter_ok_material_button"
    var tableClick = "claim_bottom_divider_image_view"

    @Before
    fun pagesAbout() {
        install()
    }


    @Test
    fun filtersMaterialButtonOpenTest() {
        clickText("Open")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        claimsTextWait("Open")
        assertEquals(textSee("Open"), true)
    }

    @Test
    fun filtersMaterialButtonAllTest() {
        clickText("Open")
        clickText("In progress")
        clickText("Executed")
        clickText("Cancelled")
        clickElement(buttonOk)
        waitUpdate(100)
        clickElement(tableClick)
        claimsTextWait("Title")
        back();
        claimsTextWait("Claims")
        clickElement(tableClick)
        claimsTextWait("Canceled")
        assertEquals(textSee("Canceled"), true)
    }

    @Test
    fun filtersMaterialButtontInProgressExecutedCancelledTest() {
        clickText("In progress")
        clickText("Executed")
        clickText("Cancelled")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        waitUpdate(100)
        clickElement(tableClick)
        claimsTextWait("Title")
        back();
        clickElement(tableClick)
        claimsTextWait("Canceled")
        assertEquals(textSee("Canceled"), true)

    }

    @Test
    fun filtersMaterialButtontOpenExecutedCancelledTest() {
        clickText("Open")
        clickText("Executed")
        clickText("Cancelled")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        claimsTextWait("Title")
        back()
        claimsTextWait("Claims")
        clickElement(tableClick)
        claimsTextWait("Canceled")
        assertEquals(textSee("Canceled"), true)
    }

    @Test
    fun filtersMaterialButtontOpenInProgressCancelled() {
        clickText("Open")
        clickText("In progress")
        clickText("Cancelled")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        claimsTextWait("Title")
        back()
        claimsTextWait("Claims")
        clickElement(tableClick)
        claimsTextWait("Canceled")
        assertEquals(textSee("Canceled"), true)

    }

    @Test
    fun filtersMaterialButtontOpenInProgressExecutedTest() {
        clickText("Open")
        clickText("In progress")
        clickText("Executed")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        claimsTextWait("Title")
        back()
        claimsTextWait("Claims")
        clickElement(tableClick)
        claimsTextWait("Executed")
        assertEquals(textSee("Executed"), true)
    }

    @Test
    fun filtersMaterialButtontExecutedCanceledTest() {
        clickText("Cancelled")
        clickText("Executed")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        claimsTextWait("Title")
        back()
        claimsTextWait("Claims")
        clickElement(tableClick)
        claimsTextWait("Canceled")
        assertEquals(textSee("Canceled"), true)

    }

    @Test
    fun filtersMaterialButtontOpenInProgressTest() {
        clickText("Open")
        clickText("In progress")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        claimsTextWait("Open")
        assertEquals(textSee("Open"), true)

    }

    @Test
    fun filtersMaterialButtontOpenExecutedTest() {
        clickText("Open")
        clickText("Executed")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        log()
        claimsTextWait("Executed")
        assertEquals(textSee("Executed"), true)
    }

    @Test
    fun filtersMaterialButtontOpenCanceledTest() {
        clickText("Open")
        clickText("Cancelled")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        log()
        claimsTextWait("Canceled")
        assertEquals(textSee("Canceled"), true)
    }

    @Test
    fun filtersMaterialButtontInProgressExecutedTest() {
        clickText("In progress")
        clickText("Executed")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        log()
        claimsTextWait("Executed")
        assertEquals(textSee("Executed"), true)
    }

    @Test
    fun filtersMaterialButtontInProgressCanceledTest() {
        clickText("In progress")
        clickText("Cancelled")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        log()
        claimsTextWait("Canceled")
        assertEquals(textSee("Canceled"), true)
    }

    @Test
    fun filtersMaterialButtontCanceledTest() {
        clickText("Cancelled")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        log()
        claimsTextWait("Canceled")
        assertEquals(textSee("Canceled"), true)
    }

    @Test
    fun filtersMaterialButtontInProgressTest() {
        clickText("In progress")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        log()
        claimsTextWait("In progress")
        assertEquals(textSee("In progress"), true)
    }

    @Test
    fun filtersMaterialButtontExecutedTest() {
        clickText("Executed")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        log()
        claimsTextWait("Executed")
        assertEquals(textSee("Executed"), true)
    }

    @Test
    fun filterMasterButtonOpen() {
        clickText("Open")
        clickElement(buttonOk)
        claimWaitElement(tableClick)
        clickElement(tableClick)
        log()
        claimsTextWait("Open")
        assertEquals(textSee("Open"), true)

    }

    @Test
    fun filtersMaterialButtontNullTest() {
        clickElement(buttonOk)
        claimsTextWait("REFRESH")
        assertEquals(textSee("REFRESH"), true)
    }

    fun log() {
        claimsTextWait("Title")
        back()
        claimWaitElement(tableClick)
        clickElement(tableClick)
    }
}

