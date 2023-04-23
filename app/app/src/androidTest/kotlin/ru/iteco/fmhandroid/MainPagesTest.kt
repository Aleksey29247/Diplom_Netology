package ru.iteco.fmhandroid;

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
class MainPagesTest {
    val MODEL_PACKAGE = "ru.iteco.fmhandroid"
    var status = 0;
    val TIMEOUT = 15000L
    val packageName = MODEL_PACKAGE
    private lateinit var device: UiDevice
    private fun waitForPackage(packageName: String) {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        context.startActivity(intent)
        val launcherPackage = device.launcherPackageName
        device.wait(Until.hasObject(By.pkg(launcherPackage)), TIMEOUT)
    }

    @Test
    fun StringNewsTest() {
        waitForPackage(packageName)
        device.findObject(By.text("News")).click()
    }

    @Test
    fun ExpandMaterialButtonUpDownTest() {
        waitForPackage(packageName)
        device.findObject(By.res(packageName, "expand_material_button")).click();
        Thread.sleep(2000)
        device.findObject(By.res(packageName, "expand_material_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("ALL NEWS")).text, "ALL NEWS")
    }

    @Test
    fun AllNewsTextViewTest() {
        waitForPackage(packageName)
        device.findObject(By.res(packageName, "all_news_text_view")).click();
        Thread.sleep(1000)
        assertEquals(device.findObject(By.text("News")).text, "News")
    }
}