package ru.iteco.fmhandroid;


import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.uiautomator.*

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ClassMain

@RunWith(AndroidJUnit4::class)
class NewsFilterTest : ClassMain(){
    val buttonMenu = "main_menu_image_button"
    val buttonFilter = "filter_news_material_button"
    val buttonSetFilter = "filter_button"
    val editBeginDataNews = "news_item_publish_date_start_text_input_edit_text"
    val editEndDataNews = "news_item_publish_date_end_text_input_edit_text"
    //ru.iteco.fmhandroid:id/text_input_end_icon
    val listText = "text_input_end_icon"

    @Before
    fun newsFilterPages() {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
        waitElement(buttonFilter)
        getElement(buttonFilter).click()
    }

    @Test
    fun editerCatigoryTest() {
        getText("Category").setText("wer")
        getElement(buttonSetFilter).click()
        waitText("News")
        assertEquals(getText("News").text, "News")
    }

    @Test
    fun editerCatigoryDate1Test() {
        getText("Category").setText("wer")
        getElement(editBeginDataNews).setText("21.04.2023")
        getElement(buttonSetFilter).click()
        waitText("Wrong period")
        assertEquals(getText("Wrong period").text, "Wrong period")
    }

    @Test
    fun editerCatigoryDate2Test() {
        getText("Category").setText("wer")
        getElement(editBeginDataNews).setText("21.04.2023")
        getElement(editEndDataNews).text = "22.04.2023";
        getElement(buttonSetFilter).click()
        waitText("News")
        assertEquals(getText("News").text, "News")
    }

    @Test
    fun editerCatigoryNameTest() {
        getText("Category").setText("Объявление")
        waitText("Объявление")
        getElement(buttonSetFilter).click()
        waitText("News")
        assertEquals(getText("News").text, "News")
    }

    @Test
    fun editerCatigoryAdvertisementDate1Test() {
        getElement(listText).click()
        waitText("Объявление")
        getText("Объявление").click()
        getElement(editBeginDataNews).setText("23.04.2023")
        getElement(buttonSetFilter).click()
        waitText("Wrong period")
        assertEquals(getText("Wrong period").text, "Wrong period")
    }

    @Test
    fun editerCatigoryAdvertisementDate2Test() {
        waitElement(listText)
        getElement(listText).click()
        waitText("Объявление")
        getText("Объявление").click()
        getElement(editBeginDataNews).setText("21.04.2023")
        getElement(editEndDataNews).text = "22.04.2023";
        getElement(buttonSetFilter).click()
        waitText("TestTitle221210")
        assertEquals(getText("TestTitle221210").text, "TestTitle221210")

    }

    @Test
    fun editerCatigoryBirthdaysWithoutaTest() {
        getElement(listText).click()
        waitText("Объявление")
        getText("День рождения").click()
        getElement(buttonSetFilter).click()
        waitText("Changed_news")
        assertEquals(getText("Changed_news").text, "Changed_news")

    }

    @Test
    fun editerCatigorySalaryTest() {
        getElement(listText).click()
        waitText("Объявление")
        getText("Зарплата").click()
        getElement(buttonSetFilter).click()
        waitText("News")
        assertEquals(getText("News").text, "News")

    }

    @Test
    fun editerCatigoryBirthdaysWithoutaDate1Test() {
        getElement(listText).click()
        waitText("День рождения")
        getText("День рождения").click()
        getElement(editBeginDataNews).setText("23.04.2023")
        getElement(buttonSetFilter).click()
        waitText("Wrong period")
        assertEquals(getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryBirthdaysWithoutaDate2Test() {
        getElement(listText).click()
        waitText("День рождения")
        getText("День рождения").click()
        getElement(editBeginDataNews).setText("22.04.2023")
        getElement(editEndDataNews).text = "23.04.2023";
        getElement(buttonSetFilter).click()
        waitText("REFRESH")
        assertEquals(getText("REFRESH").text, "REFRESH")

    }

    @Test
    fun editerCategoryTradeUnionTest() {
        getElement(listText).click()
        waitText("Профсоюз")
        getText("Профсоюз").click()
        getElement(buttonSetFilter).click()
        waitText("News")
        assertEquals(getText("News").text, "News")


    }

    @Test
    fun editerCatigoryTradeUnionDate1Test() {
        getElement(listText).click()
        waitText("Профсоюз")
        getText("Профсоюз").click()
        getElement(editBeginDataNews).setText("23.04.2023")
        getElement(buttonSetFilter).click()
        waitText("Wrong period")
        assertEquals(getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryTradeUnionDate2Test() {
        getElement(listText).click()
        waitText("Профсоюз")
        getText("Профсоюз").click()
        getElement(editBeginDataNews).setText("22.04.2023")
        getElement(editEndDataNews).text = "21.04.2023";
        getElement(buttonSetFilter).click()
        waitText("REFRESH")
        assertEquals(getText("REFRESH").text, "REFRESH")

    }

    @Test
    fun editerCategoryHolidayTest() {
        getElement(listText).click()
        waitText("Праздник")
        getText("Праздник").click()
        getElement(buttonSetFilter).click()
        waitText("News")
        assertEquals(getText("News").text, "News")

    }

    @Test
    fun editerCatigoryHolidayDate1Test() {
        getElement(listText).click()
        waitText("Праздник")
        getText("Праздник").click()
        getElement(editBeginDataNews).setText("23.04.2023")
        getElement(buttonSetFilter).click()
        waitText("Wrong period")
        assertEquals(getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryHolidayDate2Test() {
        getElement(listText).click()
        waitText("Праздник")
        getText("Праздник").click()
        getElement(editBeginDataNews).setText("22.04.2023")
        getElement(editEndDataNews).text = "21.04.2023";
        getElement(buttonSetFilter).click()
        waitText("REFRESH")
        assertEquals(getText("REFRESH").text, "REFRESH")

    }

    @Test
    fun editerCategoryMassageTest() {
        getElement(listText).click()
        waitText("Массаж")
        getText("Массаж").click()
        getElement(buttonSetFilter).click()
        waitText("News")
        assertEquals(getText("News").text, "News")

    }

    @Test
    fun editerCatigoryMassageDate1Test() {
        getElement(listText).click()
        waitText("Массаж")
        getText("Массаж").click()
        getElement(editBeginDataNews).setText("23.04.2023")
        getElement(buttonSetFilter).click()
        waitText("Wrong period")
        assertEquals(getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryMassageDate2Test() {
        getElement(listText).click()
        waitText("Массаж")
        getText("Массаж").click()
        getElement(editBeginDataNews).setText("22.04.2023")
        getElement(editEndDataNews).text = "21.04.2023";
        getElement(buttonSetFilter).click()
        waitText("REFRESH")
        assertEquals(getText("REFRESH").text, "REFRESH")

    }

    @Test
    fun editerCategoryGratitudeTest() {
        getElement(listText).click()
        waitText("Благодарность")
        getText("Благодарность").click()
        getElement(buttonSetFilter).click()
        waitText("News")
        assertEquals(getText("News").text, "News")

    }

    @Test
    fun editerCatigoryGratitudeDate1Test() {
        getElement(listText).click()
        waitText("Благодарность")
        getText("Благодарность").click()
        getElement(editBeginDataNews).setText("23.04.2023")
        getElement(buttonSetFilter).click()
        waitText("Wrong period")
        assertEquals(getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryGratitudeDate2Test() {
        getElement(listText).click()
        waitText("Благодарность")
        getText("Благодарность").click()
        getElement(editBeginDataNews).setText("22.04.2023")
        getElement(editEndDataNews).text = "21.04.2023";
        getElement(buttonSetFilter).click()
        waitText("REFRESH")
        assertEquals(getText("REFRESH").text, "REFRESH")

    }

    @Test
    fun editerCategoryNeedHelpTest() {
        getElement(listText).click()
        waitText("Нужна помощь")
        getText("Нужна помощь").click()
        getElement(buttonSetFilter).click()
        waitText("News")
        assertEquals(getText("News").text, "News")

    }

    @Test
    fun editerCatigoryNeedHelpDate1Test() {
        getElement(listText).click()
        waitText("Нужна помощь")
        getText("Нужна помощь").click()
        getElement(editBeginDataNews).setText("23.04.2023")
        getElement(buttonSetFilter).click()
        waitText("Wrong period")
        assertEquals(getText("Wrong period").text, "Wrong period")

    }

    @Test
    fun editerCatigoryNeedHelpDate2Test() {
        getElement(listText).click()
        waitText("Нужна помощь")
        getText("Нужна помощь").click()
        getElement(editBeginDataNews).setText("22.04.2023")
        getElement(editEndDataNews).text = "21.04.2023";
        getElement(buttonSetFilter).click()
        waitText("REFRESH")
        assertEquals(getText("REFRESH").text, "REFRESH")

    }

}