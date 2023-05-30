package ru.iteco.fmhandroid

//ok

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ToolsBarTest {

    val cm = ClassMain()
    val buttonAuthorization = "authorization_image_button"
    val buttonMenu = "main_menu_image_button"
    val imageTrademark = "trademark_image_view"
    val buttonProfel = "our_mission_image_button"
    val buttonExit = "title"

    @Before
    fun mainPages() {
        cm.ClassMain()
    }

    @Test
    fun mainMenuButtonTest() {
        cm.getElement(buttonMenu).click()
        cm.waitText("Main")
        assertEquals(cm.getText("Main").text, "Main")
    }

    @Test
    fun menuClaimsTest() {
        cm.getElement(buttonMenu).click()
        cm.waitText("Claims")
        cm.getText("Claims").click()
        cm.waitText("Claims")
        assertEquals(cm.getText("Claims").text, "Claims")
    }

    @Test
    fun menuNewsTest() {
        cm.getElement(buttonMenu).click()
        cm.waitText("News")
        cm.getText("News").click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")
    }

    @Test
    fun menuAboutTest() {
        cm.getElement(buttonMenu).click()
        cm.waitText("About")
        cm.getText("About").click()
        cm.waitText("Version:")
        assertEquals(cm.getText("Version:").text, "Version:")
    }

    @Test
    fun clickImageTest() {
        cm.getElement(imageTrademark).click()
        assertEquals(cm.getText("Claims").text, "Claims")
    }

    @Test
    fun ourMissionImageButtonTest() {
        cm.getElement(buttonProfel).click()
        cm.waitText("Love is all")
        assertEquals(cm.getText("Love is all").text, "Love is all")
    }

    @Test
    fun loginOutTest() {
        cm.getElement(buttonAuthorization).click()
        cm.waitElementAndroid(buttonExit)
        cm.getElementAndroid(buttonExit).click()
        cm.waitText("Authorization")
        assertEquals(cm.getText("Authorization").text, "Authorization")
    }
}