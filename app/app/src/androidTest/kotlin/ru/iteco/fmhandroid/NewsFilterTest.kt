package ru.iteco.fmhandroid;


import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.uiautomator.*

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ClassMain

@RunWith(AndroidJUnit4::class)
class NewsFilterTest {
    val cm = ClassMain()
    val buttonMenu = "main_menu_image_button"
    val buttonFilter = "filter_news_material_button"
    val buttonSetFilter = "filter_button"
    val editBeginDataNews = "news_item_publish_date_start_text_input_edit_text"
    val editEndDataNews = "news_item_publish_date_end_text_input_edit_text"
    val listText = "text_input_end_icon"

    @Before
    fun NewsFilterPages() {
        cm.ClassMain()
        cm.getElement(buttonMenu).click()
        cm.waitText("News")
        cm.getText("News").click()
        cm.waitElement(buttonFilter)
        cm.getElement(buttonFilter).click()
    }

    @Test
    fun editerCatigoryTest() {
        cm.getText("Category").setText("wer")
        cm.getElement(buttonSetFilter).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")
    }

    @Test
    fun editerCatigoryDate1Test() {
        cm.getText("Category").setText("wer")
        cm.getElement(editBeginDataNews).setText("21.04.2023")
        cm.getElement(buttonSetFilter).click()
        cm.waitText("Wrong period")
        assertEquals(cm.getText("Wrong period").text, "Wrong period")
    }

    @Test
    fun editerCatigoryDate2Test() {
        cm.getText("Category").setText("wer")
        cm.getElement(editBeginDataNews).setText("21.04.2023")
        cm.getElement(editEndDataNews).text = "22.04.2023";
        cm.getElement(buttonSetFilter).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")
    }

    @Test
    fun editerCatigoryNameTest() {
        cm.getText("Category").setText("Объявление")
        cm.getElement(buttonSetFilter).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")
    }

    @Test
    fun editerCatigoryAdvertisementDate1Test() {
        cm.getElement(listText).click()
        cm.waitText("Объявление")
        cm.getText("Объявление").click()
        cm.getElement(editBeginDataNews).setText("23.04.2023")
        cm.getElement(buttonSetFilter).click()
        cm.waitText("Wrong period")
        assertEquals(cm.getText("Wrong period").text, "Wrong period")
    }

    @Test
    fun editerCatigoryAdvertisementDate2Test() {
        cm.getElement(listText).click()
        cm.waitText("Объявление")
        cm.getText("Объявление").click()
        cm.getElement(editBeginDataNews).setText("21.04.2023")
        cm.getElement(editEndDataNews).text = "22.04.2023";
        cm.getElement(buttonSetFilter).click()
        cm.waitText("TestTitle221210")
        assertEquals(cm.getText("TestTitle221210").text, "TestTitle221210")

    }

    @Test
    fun editerCatigoryBirthdaysWithoutaTest() {
        cm.getElement(listText).click()
        cm.waitText("Объявление")
        cm.getText("День рождения").click()
        cm.getElement(buttonSetFilter).click()
        cm.waitText("Changed_news")
        assertEquals(cm.getText("Changed_news").text, "Changed_news")

    }

    @Test
    fun editerCatigorySalaryTest() {
        cm.getElement(listText).click()
        cm.waitText("Объявление")
        cm.getText("Зарплата").click()
        cm.getElement(buttonSetFilter).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")

    }

    @Test
    fun editerCatigoryBirthdaysWithoutaDate1Test() {
        cm.getElement(listText).click()
        cm.waitText("День рождения")
        cm.getText("День рождения").click()
        cm.getElement(editBeginDataNews).setText("23.04.2023")
        cm.getElement(buttonSetFilter).click()
        cm.waitText("Wrong period")
        assertEquals(cm.getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryBirthdaysWithoutaDate2Test() {
        cm.getElement(listText).click()
        cm.waitText("День рождения")
        cm.getText("День рождения").click()
        cm.getElement(editBeginDataNews).setText("22.04.2023")
        cm.getElement(editEndDataNews).text = "23.04.2023";
        cm.getElement(buttonSetFilter).click()
        cm.waitText("REFRESH")
        assertEquals(cm.getText("REFRESH").text, "REFRESH")

    }

    @Test
    fun editerCategoryTradeUnionTest() {
        cm.getElement(listText).click()
        cm.waitText("Профсоюз")
        cm.getText("Профсоюз").click()
        cm.getElement(buttonSetFilter).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")


    }

    @Test
    fun editerCatigoryTradeUnionDate1Test() {
        cm.getElement(listText).click()
        cm.waitText("Профсоюз")
        cm.getText("Профсоюз").click()
        cm.getElement(editBeginDataNews).setText("23.04.2023")
        cm.getElement(buttonSetFilter).click()
        cm.waitText("Wrong period")
        assertEquals(cm.getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryTradeUnionDate2Test() {
        cm.getElement(listText).click()
        cm.waitText("Профсоюз")
        cm.getText("Профсоюз").click()
        cm.getElement(editBeginDataNews).setText("22.04.2023")
        cm.getElement(editEndDataNews).text = "21.04.2023";
        cm.getElement(buttonSetFilter).click()
        cm.waitText("REFRESH")
        assertEquals(cm.getText("REFRESH").text, "REFRESH")

    }

    @Test
    fun editerCategoryHolidayTest() {
        cm.getElement(listText).click()
        cm.waitText("Праздник")
        cm.getText("Праздник").click()
        cm.getElement(buttonSetFilter).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")

    }

    @Test
    fun editerCatigoryHolidayDate1Test() {
        cm.getElement(listText).click()
        cm.waitText("Праздник")
        cm.getText("Праздник").click()
        cm.getElement(editBeginDataNews).setText("23.04.2023")
        cm.getElement(buttonSetFilter).click()
        cm.waitText("Wrong period")
        assertEquals(cm.getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryHolidayDate2Test() {
        cm.getElement(listText).click()
        cm.waitText("Праздник")
        cm.getText("Праздник").click()
        cm.getElement(editBeginDataNews).setText("22.04.2023")
        cm.getElement(editEndDataNews).text = "21.04.2023";
        cm.getElement(buttonSetFilter).click()
        cm.waitText("REFRESH")
        assertEquals(cm.getText("REFRESH").text, "REFRESH")

    }

    @Test
    fun editerCategoryMassageTest() {
        cm.getElement(listText).click()
        cm.waitText("Массаж")
        cm.getText("Массаж").click()
        cm.getElement(buttonSetFilter).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")

    }

    @Test
    fun editerCatigoryMassageDate1Test() {
        cm.getElement(listText).click()
        cm.waitText("Массаж")
        cm.getText("Массаж").click()
        cm.getElement(editBeginDataNews).setText("23.04.2023")
        cm.getElement(buttonSetFilter).click()
        cm.waitText("Wrong period")
        assertEquals(cm.getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryMassageDate2Test() {
        cm.getElement(listText).click()
        cm.waitText("Массаж")
        cm.getText("Массаж").click()
        cm.getElement(editBeginDataNews).setText("22.04.2023")
        cm.getElement(editEndDataNews).text = "21.04.2023";
        cm.getElement(buttonSetFilter).click()
        cm.waitText("REFRESH")
        assertEquals(cm.getText("REFRESH").text, "REFRESH")


    }

    @Test
    fun editerCategoryGratitudeTest() {
        cm.getElement(listText).click()
        cm.waitText("Благодарность")
        cm.getText("Благодарность").click()
        cm.getElement(buttonSetFilter).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")

    }

    @Test
    fun editerCatigoryGratitudeDate1Test() {
        cm.getElement(listText).click()
        cm.waitText("Благодарность")
        cm.getText("Благодарность").click()
        cm.getElement(editBeginDataNews).setText("23.04.2023")
        cm.getElement(buttonSetFilter).click()
        cm.waitText("Wrong period")
        assertEquals(cm.getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryGratitudeDate2Test() {
        cm.getElement(listText).click()
        cm.waitText("Благодарность")
        cm.getText("Благодарность").click()
        cm.getElement(editBeginDataNews).setText("22.04.2023")
        cm.getElement(editEndDataNews).text = "21.04.2023";
        cm.getElement(buttonSetFilter).click()
        cm.waitText("REFRESH")
        assertEquals(cm.getText("REFRESH").text, "REFRESH")

    }

    @Test
    fun editerCategoryNeedHelpTest() {
        cm.getElement(listText).click()
        cm.waitText("Нужна помощь")
        cm.getText("Нужна помощь").click()
        cm.getElement(buttonSetFilter).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")

    }

    @Test
    fun editerCatigoryNeedHelpDate1Test() {
        cm.getElement(listText).click()
        cm.waitText("Нужна помощь")
        cm.getText("Нужна помощь").click()
        cm.getElement(editBeginDataNews).setText("23.04.2023")
        cm.getElement(buttonSetFilter).click()
        cm.waitText("Wrong period")
        assertEquals(cm.getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryNeedHelpDate2Test() {
        cm.getElement(listText).click()
        cm.waitText("Нужна помощь")
        cm.getText("Нужна помощь").click()
        cm.getElement(editBeginDataNews).setText("22.04.2023")
        cm.getElement(editEndDataNews).text = "21.04.2023";
        cm.getElement(buttonSetFilter).click()
        cm.waitText("REFRESH")
        assertEquals(cm.getText("REFRESH").text, "REFRESH")

    }

}