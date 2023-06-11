package ru.iteco.fmhandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ToolsBarTest : ClassMain(){

    val buttonAuthorization = "authorization_image_button"
    val buttonMenu = "main_menu_image_button"
    val imageTrademark = "trademark_image_view"
    val buttonProfel = "our_mission_image_button"
    val buttonExit = "title"

    @Before
    fun mainPages() {
        ClassMain()
    }

    @Test
    fun mainMenuButtonTest() {
        getElement(buttonMenu).click()
        waitText("Main")
        assertEquals(getText("Main").text, "Main")
    }

    @Test
    fun menuClaimsTest() {
        getElement(buttonMenu).click()
        waitText("Claims")
        getText("Claims").click()
        waitText("Claims")
        assertEquals(getText("Claims").text, "Claims")
    }

    @Test
    fun menuNewsTest() {
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
        waitText("News")
        assertEquals(getText("News").text, "News")
    }

    @Test
    fun menuAboutTest() {
        getElement(buttonMenu).click()
        waitText("About")
        getText("About").click()
        waitText("Version:")
        assertEquals(getText("Version:").text, "Version:")
    }

    @Test
    fun clickImageTest() {
        getElement(imageTrademark).click()
        assertEquals(getText("Claims").text, "Claims")
    }

    @Test
    fun ourMissionImageButtonTest() {
        getElement(buttonProfel).click()
        waitText("Love is all")
        assertEquals(getText("Love is all").text, "Love is all")
    }

    @Test
    fun loginOutTest() {
        getElement(buttonAuthorization).click()
        waitElementAndroid(buttonExit)
        getElementAndroid(buttonExit).click()
        waitText("Authorization")
        assertEquals(getText("Authorization").text, "Authorization")
    }
}