package ru.iteco.fmhandroid;

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*


open class ClassMain() {
    val MODEL_PACKAGE = "ru.iteco.fmhandroid"
    val TIMEOUT = 45000L
    val timeOutIn = 15000L
    val packageName = MODEL_PACKAGE
    private lateinit var device: UiDevice


    fun intistal() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        context.startActivity(intent)
    }

    fun ClassMain() {
        intistal()
        val status = device.wait(Until.findObject(By.text("News")), timeOutIn)
        if (status == null) {
            getText("Login").setText("login2")
            getText("Password").setText("password2")
            getElement("enter_button").click()
            waitText("News")
        }
    }

    fun getElementChrome(str: String): UiObject2 {
        return device.findObject(By.res("org.chromium.webview_shell:id/" + str))
    }

    fun getText(str: String): UiObject2 {

        return (device.findObject(By.text(str)))
    }

    fun returnText(str: String): String {

        if (device.findObject(By.text(str)) == null) {
            return "null"
        } else {
            device.findObject(By.text(str)).text
        }
        return device.findObject(By.text(str)).text
    }

    fun getElement(str: String): UiObject2 {
        return device.findObject(By.res(packageName, str))
    }

    fun getElementAndroid(str: String): UiObject2 {
        return device.findObject(By.res("android:id/" + str))
    }

    fun wait15s(str: String) {
        device.wait(Until.findObject(By.text(str)), timeOutIn)
    }

    fun textBool(str: String): Boolean {
        if (device.findObject(By.text(str)) == null) {
            return false
        } else {
            return true
        }
    }

    fun waitElementChrome(str: String): UiObject2 {
        return device.wait(
            Until.findObject(By.res("org.chromium.webview_shell:id/" + str)),
            TIMEOUT
        )
    }

    fun waitText(str: String) {
        device.wait(Until.findObject(By.text(str)), TIMEOUT)
    }

    fun waitElement(str: String) {
        device.wait(Until.findObject(By.res(packageName, str)), TIMEOUT)
    }

    fun back() {
        device.pressBack()
    }

    fun waitUpdate(timeSecond: Long): Int {
        if (timeSecond <= 0) {
            device.waitForWindowUpdate(null, TIMEOUT)
            return 1;
        } else {
            device.waitForWindowUpdate(null, timeSecond * 1000)
            return 0;
        }
    }

    fun waitElementAndroid(str: String): UiObject2 {

        return device.wait(Until.findObject(By.res("android:id/" + str)), TIMEOUT)
    }

    fun bug() {
        ///body write
    }


}