
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
class ClaimsPagesTest
{
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
    fun PagesAbout(){
        waitForPackage(packageName)

        device.findObject(By.res("ru.iteco.fmhandroid:id/main_menu_image_button")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Claims")).click()
        Thread.sleep(2000)
        device.findObject(By.res(  "ru.iteco.fmhandroid:id/filters_material_button")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Open")).click()
        device.findObject(By.text("In progress")).click()
    }

    @Test
    fun FiltersMaterialButtonOpenTest()
    {
        device.findObject(By.text("Open")).click()
        Thread.sleep(2000)
        device.findObject(By.res(  "ru.iteco.fmhandroid:id/claim_list_filter_ok_material_button")).click()
        Thread.sleep(2000)
        device.findObject(By.res("ru.iteco.fmhandroid:id/claim_bottom_divider_image_view")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Open")).text, "Open")
    }
    @Test
    fun FiltersMaterialButtonAllTest()
    {
        device.findObject(By.text("Open")).click()
        device.findObject(By.text("In progress")).click()
        device.findObject(By.text("Executed")).click()
        device.findObject(By.text("Cancelled")).click()
        Thread.sleep(2000)
        device.findObject(By.res(  "ru.iteco.fmhandroid:id/claim_list_filter_ok_material_button")).click()
        Thread.sleep(10000)
        device.findObject(By.res("ru.iteco.fmhandroid:id/claim_bottom_divider_image_view")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Canceled")).text, "Canceled")
    }

}