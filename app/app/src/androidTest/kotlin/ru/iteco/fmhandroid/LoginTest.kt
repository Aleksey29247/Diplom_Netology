package ru.iteco.fmhandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.After
import ru.iteco.fmhandroid.ClassMain

@RunWith(AndroidJUnit4::class)
class LoginTest {
    val cm = ClassMain()
    val buttonLogin = "enter_button"
    val textAuthorization = "Authorization"

    @Before
    fun beforeEachTest() {
        cm.intistal()
        cm.wait15s("Authorization")
        if (cm.textBool("Authorization") == false) {
            exitLogin()
        }
    }


    @Test
    fun testLoginTruePasswordFalse() {
        cm.getText("Login").setText("login2")
        cm.getText("Password").setText("password1")
        cm.getElement(buttonLogin).click()
        assertEquals(cm.getText(textAuthorization).text, textAuthorization)
    }

    @Test
    fun testLoginTruePasswordTrue() {
        cm.getText("Login").setText("login2")
        cm.getText("Password").setText("password2")
        cm.getElement(buttonLogin).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")
    }

    @Test
    fun testLoginFalsePasswordTrue() {
        cm.getText("Login").setText("login1")
        cm.getText("Password").setText("password2")
        cm.getElement(buttonLogin).click()
        assertEquals(cm.getText(textAuthorization).text, textAuthorization)
    }

    @Test
    fun testLoginFalsePasswordFalse() {
        cm.getText("Login").setText("login1")
        cm.getText("Password").setText("password1")
        cm.getElement(buttonLogin).click()
        assertEquals(cm.getText(textAuthorization).text, textAuthorization)
    }

    @After
    fun runAfterEveryTest() {
        exitLogin()
    }

    fun exitLogin() {
        if (cm.textBool("News") == true) {
            cm.getElement("authorization_image_button").click();
            cm.waitElementAndroid("title")
            cm.getElementAndroid("title").click()
        }
    }
}

