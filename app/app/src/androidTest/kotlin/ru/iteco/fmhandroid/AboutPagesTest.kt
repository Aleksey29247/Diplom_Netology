package ru.iteco.fmhandroid;
//ok

import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.uiautomator.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import  ru.iteco.fmhandroid.ClassMain

@RunWith(AndroidJUnit4::class)
class AboutPagesTest : ClassMain() {


    val buttonMenu = "main_menu_image_button"
    val url1 = "https://vhospice.org/#/privacy-policy/"
    val url2 = "https://vhospice.org/#/terms-of-use"
    val url_field = "url_field"

    @Before
    fun pagesAbout() {

        ClassMain()
        getElement(buttonMenu).click();
        waitText("About")
        getText("About").click()
        waitText(url1)

    }

    @Test
    fun privacyPoliceTest() {
        getText(url1).click()
        waitElementChrome(url_field)
        assertEquals(getElementChrome(url_field).text, url1)
    }

    @Test
    fun temsOfUseTest() {
        getText(url2).click()
        waitElementChrome(url_field)
        assertEquals(getElementChrome(url_field).text, url2)
    }

    @After
    fun EndTest() {
        back()
    }
}