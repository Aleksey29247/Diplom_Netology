package ru.iteco.fmhandroid


import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.After




@RunWith(AndroidJUnit4::class)
class LoginTest {
    //
     val SETTINGS_PACKAGE = "com.android.settings"
     val MODEL_PACKAGE = "ru.iteco.fmhandroid"

    var status =0;
    val TIMEOUT = 15000L

    private lateinit var device: UiDevice
    val packageName = MODEL_PACKAGE


    private fun waitForPackage(packageName: String) {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        context.startActivity(intent)
        val launcherPackage = device.launcherPackageName
        device.wait(Until.hasObject(By.pkg(launcherPackage)), TIMEOUT)
    }
    @Before
    fun beforeEachTest() {
    }

    @Test
    fun testLoginTruePasswordFalse() {

        waitForPackage(packageName)
        device.findObject(By.text("Login")).setText("login2")
        device.findObject(By.text("Password")).setText ("password1")
        device.findObject(By.res(packageName, "enter_button")).click()
        val UiObject = device.findObject(By.text("Authorization")).text
        val result =  UiObject
        status=0;
        assertEquals(result, "Authorization")
    }

    @Test
    fun testLoginTruePasswordTrue() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)
        device.findObject(By.text("Login")).setText("login2")
        device.findObject(By.text("Password")).setText("password2")
        device.findObject(By.res(packageName, "enter_button")).click()
        Thread.sleep(4000)
        val UiObject = device.findObject(By.text("News")).text
        val result = UiObject
        status=1
        assertEquals(result, "News")

    }

    @Test
    fun testLoginFalsePasswordTrue() {
        waitForPackage(packageName)
        device.findObject(By.text("Login")).setText("login1")
        device.findObject(By.text("Password")).setText("password2")
        device.findObject(By.res(packageName, "enter_button")).click()
        val UiObject = device.findObject(By.text("Authorization")).text
        val result = UiObject
        status=0
        assertEquals(result, "Authorization")
    }

    @Test
    fun testLoginFalsePasswordFalse() {
        waitForPackage(packageName)
        device.findObject(By.text("Login")).setText("login1")
        device.findObject(By.text("Password")).setText("password1")
        device.findObject(By.res(packageName, "enter_button")).click()
        val UiObject = device.findObject(By.text("Authorization")).text
        val result = UiObject
        status=0 /*FIXME*/
        assertEquals(result, "Authorization")
    }


    @After
    fun runAfterEveryTest() {
            /*FIXME*/


        if (status==1)
        {
            Thread.sleep(4000)
            device.findObject(By.res(packageName,"authorization_image_button")).click();
            Thread.sleep(1000)
            device.findObject(By.res("android:id/title")).click()
        }


    }




}

