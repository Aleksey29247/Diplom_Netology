package ru.iteco.fmhandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ToolsBarTest : PageObjectToolsBar(){

    val imageTrademark = "trademark_image_view"
    @Before
    fun mainPages() {
      initPage()
    }

    @Test
    fun mainMenuButtonTest() {
        buttonMenuClick()
        assertEquals(result("Main"), true)
    }

    @Test
    fun menuClaimsTest() {
       buttonClaimsClick()
        assertEquals(result("Claims"), true)
    }

    @Test
    fun menuNewsTest() {
        buttonNewsclick()
        assertEquals(result("News"), true)
    }

    @Test
    fun menuAboutTest() {
        buttonAboutClick()
        assertEquals(result("Version:"), true)
    }

    @Test
    fun clickImageTest() {
        clickImag(imageTrademark)
        assertEquals(result("Claims"), true)
    }

    @Test
    fun ourMissionImageButtonTest() {
       buttonProfel()
        assertEquals(result("Love is all"), true)
    }

    @Test
    fun loginOutTest() {
        buttonLoginOutclick()
        assertEquals(result("Authorization"), true)
    }
}