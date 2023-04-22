package ru.iteco.fmhandroid


import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ToolsBarTest {

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


    ///fun login FIXME


    @Test
    fun MainMenuButtonTest() {

        waitForPackage(packageName)
        device.findObject(By.res("ru.iteco.fmhandroid:id/main_menu_image_button")).click();
        Thread.sleep(2000)
        val UiObject = device.findObject(By.text("Main")).text
        val result = UiObject
        status=0;
        assertEquals(result, "Main")
    }


    @Test
    fun MenuClaimsTest() {

        waitForPackage(packageName)

        device.findObject(By.res("ru.iteco.fmhandroid:id/main_menu_image_button")).click();
        Thread.sleep(2000)
        ///menu_item_main
        device.findObject(By.text("Claims")).click()
        Thread.sleep(2000)
        status=0;
        assertEquals(device.findObject(By.text("Claims")).text, "Claims")



    }
    @Test
    fun MenuNewsTest()
    {
        waitForPackage(packageName)
        device.findObject(By.res("ru.iteco.fmhandroid:id/main_menu_image_button")).click();
        Thread.sleep(2000)
        ///menu_item_main
        device.findObject(By.text("News")).click()
        Thread.sleep(2000)
        status=0;
        assertEquals(device.findObject(By.text("News")).text, "News")
    }
    @Test
    fun MenuAboutTest()
    {
        waitForPackage(packageName)
        device.findObject(By.res("ru.iteco.fmhandroid:id/main_menu_image_button")).click();
        Thread.sleep(2000)
        ///menu_item_main
        device.findObject(By.text("About")).click()
        Thread.sleep(2000)
        status=1;
        assertEquals(device.findObject(By.text("Version:")).text, "Version:")
    }

    @Test
    fun ClickImageTest()
    {
        waitForPackage(packageName)
        device.findObject(By.res("ru.iteco.fmhandroid:id/trademark_image_view")).click();
        status=0;
        assertEquals(device.findObject(By.text("Claims")).text, "Claims")
    }


    @Test
    fun OurMissionImageButtonTest()
    {
        waitForPackage(packageName)
        device.findObject(By.res("ru.iteco.fmhandroid:id/our_mission_image_button")).click();
        Thread.sleep(2000)
        status=2;
        assertEquals(device.findObject(By.text("Love is all")).text, "Love is all")
    }
    @Test
    fun QLoginOutTest() {
        waitForPackage(packageName)

        device.findObject(By.res(packageName, "authorization_image_button")).click();
        Thread.sleep(1000)
        device.findObject(By.res("android:id/title")).click()
        val UiObject = device.findObject(By.text("Authorization")).text
        val result = UiObject
        Thread.sleep(4000)
        assertEquals(result, "Authorization")
    }

    @After
    fun runAfterEveryTest() {
        if (status==1)
        {
            device.findObject(By.res(packageName,"about_back_image_button")).click();

        }
        if (status==2)
        {
            device.findObject(By.res("ru.iteco.fmhandroid:id/main_menu_image_button")).click();
            Thread.sleep(2000)
            device.findObject(By.text("Main")).click()
        }


    }

}