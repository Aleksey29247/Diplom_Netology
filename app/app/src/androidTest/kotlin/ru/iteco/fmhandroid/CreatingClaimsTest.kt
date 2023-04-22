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
import java.util.*

@RunWith(AndroidJUnit4::class)
class CreatingClaimsTest {
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
    fun PagesCreate(){
        waitForPackage(packageName)

        device.findObject(By.res("ru.iteco.fmhandroid:id/main_menu_image_button")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Claims")).click()
        Thread.sleep(2000)
        device.findObject(By.res(  "ru.iteco.fmhandroid:id/add_new_claim_material_button")).click();
        Thread.sleep(2000)

    }

    @Test
    fun TitleEditText50CharTest()
    {
        device.findObject(By.res( "ru.iteco.fmhandroid:id/title_edit_text")).text="aaaaaaaasaasdaad"
        device.findObject(By.res("ru.iteco.fmhandroid:id/save_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Fill empty fields")).text,"Fill empty fields")
    }

    @Test
    fun TitleEditTextMore50CharTest()
    {
        device.findObject(By.res( "ru.iteco.fmhandroid:id/title_edit_text")).text="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        device.findObject(By.res("ru.iteco.fmhandroid:id/save_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Fill empty fields")).text,"Fill empty fields")
    }
   @Test
    fun TitleEditText50CharRusTest()
    {
        device.findObject(By.res( "ru.iteco.fmhandroid:id/title_edit_text")).text="ааавы"
        device.findObject(By.res("ru.iteco.fmhandroid:id/save_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Fill empty fields")).text,"Fill empty fields")
    }

    @Test
    fun TitleEditTextMore50CharRusTest()
    {
        device.findObject(By.res( "ru.iteco.fmhandroid:id/title_edit_text")).text="ввввввввввыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыы"
        device.findObject(By.res("ru.iteco.fmhandroid:id/save_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Fill empty fields")).text,"Fill empty fields")
    }


    @Test
    fun TextInputPlaceholderTest()
    {
        device.findObject(By.res( "ru.iteco.fmhandroid:id/text_input_end_icon")).click()
        Thread.sleep(2000)
        device.findObject(By.text("Ivanov Ivan Ivanovich")).click()
        Thread.sleep(2000)
        device.findObject(By.res("ru.iteco.fmhandroid:id/save_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Fill empty fields")).text,"Fill empty fields")
    }
    @Test
    fun DataTest()
    {
        device.findObject(By.res( "ru.iteco.fmhandroid:id/date_in_plan_text_input_edit_text")).text="01.07.1900"
        device.findObject(By.res("ru.iteco.fmhandroid:id/save_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Fill empty fields")).text,"Fill empty fields")
    }

    @Test
    fun TimeTest()
    {
        device.findObject(By.res( "ru.iteco.fmhandroid:id/time_in_plan_text_input_edit_text")).text="20:00"
        device.findObject(By.res("ru.iteco.fmhandroid:id/save_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Fill empty fields")).text,"Fill empty fields")
    }

    @Test
    fun TimeBack1HTest()
    {
        val date = Date()
        val hours = date.hours-1
        val min = date.minutes
        var timeText: String
        if (min<=9) {
            timeText = hours.toString() + ":0" + min.toString()
        }
        else{timeText = hours.toString() + ":" + min.toString()}
        device.findObject(By.res( "ru.iteco.fmhandroid:id/time_in_plan_text_input_edit_text")).text=timeText
        device.findObject(By.res("ru.iteco.fmhandroid:id/save_button")).click()
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Fill empty fields")).text,"Fill empty fields")
    }

}