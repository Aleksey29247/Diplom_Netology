
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
class AboutPagesTest {

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
        device.findObject(By.text("About")).click()
        Thread.sleep(2000)
    }


    @Test
    fun PrivacyPoliceTest(){
        //
        device.findObject(By.text("https://vhospice.org/#/privacy-policy/")).click()
        Thread.sleep(2000)
        //
        assertEquals(device.findObject(By.res("org.chromium.webview_shell:id/url_field")).text,"https://vhospice.org/#/privacy-policy/")

    }

    @Test
    fun TemsOfUseTest()
    {
        device.findObject(By.text("https://vhospice.org/#/terms-of-use")).click()
        Thread.sleep(2000)
        //
        assertEquals(device.findObject(By.res("org.chromium.webview_shell:id/url_field")).text,"https://vhospice.org/#/terms-of-use")
    }
@After
 fun EndTest()
{
    device.pressBack()
 }

}