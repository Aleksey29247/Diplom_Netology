package ru.iteco.fmhandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.After


@RunWith(AndroidJUnit4::class)
class LoginTest : PageObjectLogin() {

    @Before
    fun beforeEachTest() {
        initstalPage()
    }

    @Test
    fun testLoginTruePasswordFalse() {
        enterLogin("login2", "password1")
        buttonClick()
        assertEquals(login(), false)
    }

    @Test
    fun testLoginTruePasswordTrue() {
        enterLogin("login2", "password2")
        buttonClick()
        waitText("News")
        assertEquals(login(), true)
    }

    @Test
    fun testLoginFalsePasswordTrue() {
        enterLogin("login1", "password2")
        buttonClick()
        assertEquals(login(), false)

    }

    @Test
    fun testLoginFalsePasswordFalse() {
        enterLogin("login1", "password1")
        buttonClick()
        assertEquals(login(), false)

    }

    @After
    fun runAfterEveryTest() {
        exitLogin()
    }


}

