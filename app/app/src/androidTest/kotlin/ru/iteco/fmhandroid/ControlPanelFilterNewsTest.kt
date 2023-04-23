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
class ControlPanelFilterNewsTest {
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
    fun PagesControlPanelFilter() {
        waitForPackage(packageName)
        device.findObject(By.res("ru.iteco.fmhandroid:id/main_menu_image_button")).click();
        Thread.sleep(2000)
        device.findObject(By.text("News")).click()
        Thread.sleep(2000)
        device.findObject(By.res("ru.iteco.fmhandroid:id/edit_news_material_button")).click();
        Thread.sleep(2000)
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_news_material_button")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Active")).click() //false
        device.findObject(By.text("Not active")).click() //false
    }

    @Test
    fun CategoryWerNotData() {
        device.findObject(By.text("Category")).setText("wer")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("TestTitle")).text, "TestTitle")
    }

    @Test
    fun DateErrorTest() {
        device.findObject(By.text("Category")).setText("wer")
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text")).text =
            "war"
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Wrong period")).text, "Wrong period")
    }

    @Test
    fun NormalDataOneTest() {
        device.findObject(By.text("Category")).setText("wer")
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"))
            .click()
        Thread.sleep(2000)
        device.findObject(By.res("android:id/button1")).click()
        Thread.sleep(2000)
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Wrong period")).text, "Wrong period")
    }

    @Test
    fun NormalDataTwoTest() {
        device.findObject(By.text("Category")).setText("wer")
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"))
            .click()
        Thread.sleep(2000)
        device.findObject(By.res("android:id/button1")).click()
        Thread.sleep(2000)
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_end_text_input_edit_text"))
            .click()
        Thread.sleep(2000)
        device.findObject(By.res("android:id/button1")).click()
        Thread.sleep(2000)
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click()
        Thread.sleep(2000)
        assertEquals(
            device.findObject(By.text("There is nothing here yet…")).text,
            "There is nothing here yet…"
        )

    }

    @Test
    fun ActiveFalseNotActiverTrueTest() {
        device.findObject(By.text("Not active")).click()
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Зарплата")).text, "Зарплата")
    }
}