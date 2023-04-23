package ru.iteco.fmhandroid;

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ControlPanelNewsTest {
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

    @Before
    fun PagesControlPanel() {
        waitForPackage(packageName)
        device.findObject(By.res("ru.iteco.fmhandroid:id/main_menu_image_button")).click();
        Thread.sleep(2000)
        device.findObject(By.text("News")).click()
        Thread.sleep(2000)
        device.findObject(By.res("ru.iteco.fmhandroid:id/edit_news_material_button")).click();
        Thread.sleep(2000)
    }

    @Test
    fun SortNewsMaterialButtonZXYTest() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/sort_news_material_button")).click();
        device.findObject(By.res("ru.iteco.fmhandroid:id/sort_news_material_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("TestTitle486670")).text, "TestTitle486670")
    }

    @Test
    fun SortNewsMaterialButtonABCTest() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/sort_news_material_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Объявление")).text, "Объявление")
    }

    @Test
    fun FilterNewsMaterialButtonTest() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_news_material_button")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Active")).click()
        device.findObject(By.text("Not active")).click()
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("TestTitle")).text, "TestTitle")

    }
}