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
class NewsFilterTest {
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
    fun NewsFilterPages() {
        waitForPackage(packageName)
        device.findObject(By.res("ru.iteco.fmhandroid:id/main_menu_image_button")).click();
        Thread.sleep(2000)
        device.findObject(By.text("News")).click()
        Thread.sleep(2000)
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_news_material_button")).click();
        Thread.sleep(2000)
    }

    @Test
    fun EditerCatigoryTest() {
        device.findObject(By.text("Category")).setText("wer")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("News")).text, "News")
    }

    @Test
    fun EditerCatigoryDate1Test() {
        device.findObject(By.text("Category")).setText("wer")
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        date1.setText("21.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Wrong period")).text, "Wrong period")
    }

    @Test
    fun EditerCatigoryDate2Test() {
        device.findObject(By.text("Category")).setText("wer")
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_end_text_input_edit_text")).text =
            "22.04.2023";
        date1.setText("21.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("News")).text, "News")
    }

    @Test
    fun EditerCatigoryNameTest() {
        device.findObject(By.text("Category")).setText("Объявление")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("TestTitle221210")).text, "TestTitle221210")
    }

    @Test
    fun EditerCatigoryAdvertisementDate1Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Объявление")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        date1.setText("23.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Wrong period")).text, "Wrong period")
    }

    @Test
    fun EditerCatigoryAdvertisementDate2Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Объявление")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_end_text_input_edit_text")).text =
            "22.04.2023";
        date1.setText("21.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("TestTitle221210")).text, "TestTitle221210")
    }

    @Test
    fun EditerCatigoryBirthdaysWithoutaTest() {
        // device.findObject(By.text("Category"))
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("День рождения")).click()
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("День рождения")).text, "День рождения")
    }

    @Test
    fun EditerCatigorySalaryTest() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Зарплата")).click()
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Зарплата")).text, "Зарплата")
    }

    @Test
    fun EditerCatigoryBirthdaysWithoutaDate1Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("День рождения")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        date1.setText("23.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Wrong period")).text, "Wrong period")
    }

    @Test
    fun EditerCatigoryBirthdaysWithoutaDate2Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("День рождения")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_end_text_input_edit_text")).text =
            "22.04.2023";
        date1.setText("23.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("REFRESH")).text, "REFRESH")
    }

    @Test
    fun EditerCategoryTradeUnionTest() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Профсоюз")).click()
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Профсоюз")).text, "Профсоюз")
    }

    @Test
    fun EditerCatigoryTradeUnionDate1Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Профсоюз")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        date1.setText("23.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Wrong period")).text, "Wrong period")
    }

    @Test
    fun EditerCatigoryTradeUnionDate2Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Профсоюз")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_end_text_input_edit_text")).text =
            "22.04.2023";
        date1.setText("21.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("REFRESH")).text, "REFRESH")
    }

    @Test
    fun EditerCategoryHolidayTest() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Праздник")).click()
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Праздник")).text, "Праздник")
    }

    @Test
    fun EditerCatigoryHolidayDate1Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Праздник")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        date1.setText("23.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Wrong period")).text, "Wrong period")
    }

    @Test
    fun EditerCatigoryHolidayDate2Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Праздник")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_end_text_input_edit_text")).text =
            "22.04.2023";
        date1.setText("21.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("REFRESH")).text, "REFRESH")
    }

    @Test
    fun EditerCategoryMassageTest() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Массаж")).click()
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Массаж")).text, "Массаж")
    }

    @Test
    fun EditerCatigoryMassageDate1Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Массаж")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        date1.setText("23.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Wrong period")).text, "Wrong period")
    }

    @Test
    fun EditerCatigoryMassageDate2Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Массаж")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_end_text_input_edit_text")).text =
            "22.04.2023";
        date1.setText("21.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("REFRESH")).text, "REFRESH")
    }

    @Test
    fun EditerCategoryGratitudeTest() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Благодарность")).click()
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Благодарность")).text, "Благодарность")
    }

    @Test
    fun EditerCatigoryGratitudeDate1Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Благодарность")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        date1.setText("23.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Wrong period")).text, "Wrong period")
    }

    @Test
    fun EditerCatigoryGratitudeDate2Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Благодарность")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_end_text_input_edit_text")).text =
            "22.04.2023";
        date1.setText("21.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("REFRESH")).text, "REFRESH")
    }

    @Test
    fun EditerCategoryNeedHelpTest() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Нужна помощь")).click()
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Нужна помощь")).text, "Нужна помощь")
    }

    @Test
    fun EditerCatigoryNeedHelpDate1Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Нужна помощь")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        date1.setText("23.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("Wrong period")).text, "Wrong period")
    }

    @Test
    fun EditerCatigoryNeedHelpDate2Test() {
        device.findObject(By.res("ru.iteco.fmhandroid:id/text_input_end_icon")).click();
        Thread.sleep(2000)
        device.findObject(By.text("Нужна помощь")).click()
        var date1 =
            device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text"));
        device.findObject(By.res("ru.iteco.fmhandroid:id/news_item_publish_date_end_text_input_edit_text")).text =
            "22.04.2023";
        date1.setText("21.04.2023")
        device.findObject(By.res("ru.iteco.fmhandroid:id/filter_button")).click();
        Thread.sleep(2000)
        assertEquals(device.findObject(By.text("REFRESH")).text, "REFRESH")
    }
}