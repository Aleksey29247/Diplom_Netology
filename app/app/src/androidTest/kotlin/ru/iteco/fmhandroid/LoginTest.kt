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
class LoginTest : ClassMain(){
    val buttonLogin = "enter_button"
    val textAuthorization = "Authorization"

    @Before
    fun beforeEachTest() {
        intistal()
        wait15s("Authorization")
        if (textBool("Authorization") == false) {
            exitLogin()
        }
    }


    @Test
    fun testLoginTruePasswordFalse() {
        getText("Login").setText("login2")
        getText("Password").setText("password1")
        getElement(buttonLogin).click()
        assertEquals(getText(textAuthorization).text, textAuthorization)
    }

    @Test
    fun testLoginTruePasswordTrue() {
        getText("Login").setText("login2")
        getText("Password").setText("password2")
        getElement(buttonLogin).click()
        waitText("News")
        assertEquals(getText("News").text, "News")
    }

    @Test
    fun testLoginFalsePasswordTrue() {
        getText("Login").setText("login1")
        getText("Password").setText("password2")
        getElement(buttonLogin).click()
        assertEquals(getText(textAuthorization).text, textAuthorization)
    }

    @Test
    fun testLoginFalsePasswordFalse() {
        getText("Login").setText("login1")
        getText("Password").setText("password1")
        getElement(buttonLogin).click()
        assertEquals(getText(textAuthorization).text, textAuthorization)
    }

    @After
    fun runAfterEveryTest() {
        exitLogin()
    }

    fun exitLogin() {
        if (textBool("News") == true) {
            getElement("authorization_image_button").click();
            waitElementAndroid("title")
            getElementAndroid("title").click()
        }
    }
}

