package ru.iteco.fmhandroid.test.done;


import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.uiautomator.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.PageObjectAbout

@RunWith(AndroidJUnit4::class)
class AboutPagesTest : PageObjectAbout() {

    val url1 = "https://vhospice.org/#/privacy-policy/"
    val url2 = "https://vhospice.org/#/terms-of-use"
    val url_field = "url_field"

    @Before
    fun pagesAbout() {
        init()
        waitPages(url1)
    }

    @Test
    fun privacyPoliceTest() {
        clickToText(url1)
        waitStartChrome(url_field)
        assertEquals(getBrowser(url_field), true)
    }

    @Test
    fun temsOfUseTest() {
        clickToText(url2)
        waitStartChrome(url_field)
        assertEquals(getBrowser(url_field), true)

    }

    @After
    fun EndTest() {
        back()
    }
}