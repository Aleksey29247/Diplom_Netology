package ru.iteco.fmhandroid

import org.junit.Assert.*
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector

import androidx.test.uiautomator.Until
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


const val SETTINGS_PACKAGE = "com.android.settings"
const val MODEL_PACKAGE = "ru.iteco.fmhandroid"

const val TIMEOUT = 5000L

@RunWith(AndroidJUnit4::class)
class LoginTest {

    private lateinit var device: UiDevice


   /* private fun waitForPackage(packageName: String) {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        context.startActivity(intent)
        device.wait(Until.hasObject(By.pkg(packageName)), TIMEOUT)
    }

    @Test
    fun testLoginTruePasswordFalse() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)
        device.findObject(By.res(packageName, "login_text_input_layout")).text = "login2"
        device.findObject(By.res(packageName, "Password")).text = "password1"
        device.findObject(By.res(packageName, "SING IN")).click()

        val result = device.findObject(By.res(packageName, "Authorization")).text
        assertEquals(result, device.findObject(By.res(packageName, "Authorization")).text)
    }
*/
    @Test
    fun testLoginFalsePasswordFalse() {
       /* val packageName = MODEL_PACKAGE
        waitForPackage(packageName)
*/
        System.out.print("test");
       System.out.print("test");
       System.out.print("test");
       System.out.print("test");
       System.out.print("test");
       System.out.print("test");
       System.out.print("test");
       System.out.print("test");
        //device.findObject(By.res(packageName, "Login")).text = "login1"
   //     device.findObject(By.res(packageName, "Password")).text = "password1"
     ///   device.findObject(By.res(packageName, "SING IN")).click()

        //val result = device.findObject(By.res(packageName, "Authorization")).text
        //assertEquals(result, device.findObject(By.res(packageName, "Authorization")).text)

    }
/*
    @Test
    fun testLoginTruePasswordTrue() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)

        device.findObject(By.res(packageName, "Login")).text = "login2"
        device.findObject(By.res(packageName, "Password")).text = "password2"
        device.findObject(By.res(packageName, "SING IN")).click()

        val result = device.findObject(By.res(packageName, "Authorization")).text
        assertEquals(result, device.findObject(By.res(packageName, "Authorization")).text)
    }

    @Test
    fun testLoginAndPasswordEmpty() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)
        device.findObject(By.res(packageName, "SING IN")).click()

        val result = device.findObject(By.res(packageName, "Authorization")).text
        assertEquals(result, device.findObject(By.res(packageName, "Authorization")).text)
    }

    @Test
    fun testLoginTruePasswordEmpty() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)

        device.findObject(By.res(packageName, "Login")).text = "login2"
        //device.findObject(By.res(packageName, "Password")).text = "password1"
        device.findObject(By.res(packageName, "SING IN")).click()

        val result = device.findObject(By.res(packageName, "Authorization")).text
        assertEquals(result, device.findObject(By.res(packageName, "Authorization")).text)
    }

    @Test
    fun testLoginEmptyPasswordTrue() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)

        //device.findObject(By.res(packageName, "Login")).text = "login2"
        device.findObject(By.res(packageName, "Password")).text = "password2"
        device.findObject(By.res(packageName, "SING IN")).click()

        val result = device.findObject(By.res(packageName, "Authorization")).text
        assertEquals(result, device.findObject(By.res(packageName, "Authorization")).text)

    }*/
}
