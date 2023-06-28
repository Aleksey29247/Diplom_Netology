package ru.iteco.fmhandroid.test.done;


import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.uiautomator.*

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.NewsFilterPageObject

@RunWith(AndroidJUnit4::class)
class NewsFilterTest : NewsFilterPageObject() {

    val buttonSetFilter = "filter_button"
    val editBeginDataNews = "news_item_publish_date_start_text_input_edit_text"
    val editEndDataNews = "news_item_publish_date_end_text_input_edit_text"

    //ru.iteco.fmhandroid:id/text_input_end_icon
    val listText = "text_input_end_icon"

    @Before
    fun newsFilterPages() {
        init()
    }

    @Test
    fun editerCatigoryTest() {
        setText("Category", "wer")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("News")
        assertEquals(seeText("News"), true)
    }

    @Test
    fun editerCatigoryDate1Test() {
        setText("Category", "wer")
        setElement(editBeginDataNews, "21.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("Wrong period")
        assertEquals(seeText("Wrong period"), true)
    }

    @Test
    fun editerCatigoryDate2Test() {
        setText("Category", "wer")
        setElement(editBeginDataNews, "21.04.2023")
        setElement(editEndDataNews, "22.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("News")
        assertEquals(seeText("News"), true)
    }

    @Test
    fun editerCatigoryNameTest() {
        setText("Category", "Объявление")
        waitTextNewsFilter("Объявление")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("News")
        assertEquals(seeText("News"), true)
    }

    @Test
    fun editerCatigoryAdvertisementDate1Test() {
        clickElement(listText)
        waitTextNewsFilter("Объявление")
        clickText("Объявление")
        setElement(editBeginDataNews, "23.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("Wrong period")
        assertEquals(seeText("Wrong period"), true)
    }

    @Test
    fun editerCatigoryAdvertisementDate2Test() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Объявление")
        clickText("Объявление")
        setElement(editBeginDataNews, "21.04.2023")
        setElement(editEndDataNews, "22.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("TestTitle221210")
        assertEquals(seeText("TestTitle221210"), true)

    }

    @Test
    fun editerCatigoryBirthdaysWithoutaTest() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Объявление")
        clickText("День рождения")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("День рождения")
        assertEquals(seeText("День рождения"), true)

    }

    @Test
    fun editerCatigorySalaryTest() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Объявление")
        clickText("Зарплата")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("News")
        assertEquals(seeText("News"), true)

    }

    @Test
    fun editerCatigoryBirthdaysWithoutaDate1Test() {
        clickElement(listText)
        waitTextNewsFilter("День рождения")
        clickText("День рождения")
        setElement(editBeginDataNews, "23.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("Wrong period")
        assertEquals(seeText("Wrong period"), true)

    }

    @Test
    fun editerCatigoryBirthdaysWithoutaDate2Test() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("День рождения")
        clickText("День рождения")
        setElement(editBeginDataNews, "22.04.2023")
        setElement(editEndDataNews, "23.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("REFRESH")
        assertEquals(seeText("REFRESH"), true)

    }

    @Test
    fun editerCategoryTradeUnionTest() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Профсоюз")
        clickText("Профсоюз")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("News")
        assertEquals(seeText("News"), true)

    }

    @Test
    fun editerCatigoryTradeUnionDate1Test() {
        clickElement(listText)
        waitTextNewsFilter("Профсоюз")
        clickText("Профсоюз")
        setElement(editBeginDataNews, "23.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("Wrong period")
        assertEquals(seeText("Wrong period"), true)

    }

    @Test
    fun editerCatigoryTradeUnionDate2Test() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Профсоюз")
        clickText("Профсоюз")
        setElement(editBeginDataNews, "22.04.2023")
        setElement(editEndDataNews, "21.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("REFRESH")
        assertEquals(seeText("REFRESH"), true)

    }

    @Test
    fun editerCategoryHolidayTest() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Праздник")
        clickText("Праздник")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("News")
        assertEquals(seeText("News"), true)
    }

    @Test
    fun editerCatigoryHolidayDate1Test() {
        clickElement(listText)
        waitTextNewsFilter("Праздник")
        clickText("Праздник")
        setElement(editBeginDataNews, "23.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("Wrong period")
        assertEquals(seeText("Wrong period"), true)

    }

    @Test
    fun editerCatigoryHolidayDate2Test() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Праздник")
        clickText("Праздник")
        setElement(editBeginDataNews, "22.04.2023")
        setElement(editEndDataNews, "21.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("REFRESH")
        assertEquals(seeText("REFRESH"), true)

    }

    @Test
    fun editerCategoryMassageTest() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Массаж")
        clickText("Массаж")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("News")
        assertEquals(seeText("News"), true)

    }

    @Test
    fun editerCatigoryMassageDate1Test() {
        clickElement(listText)
        waitTextNewsFilter("Массаж")
        clickText("Массаж")
        setElement(editBeginDataNews, "23.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("Wrong period")
        assertEquals(seeText("Wrong period"), true)

    }

    @Test
    fun editerCatigoryMassageDate2Test() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Массаж")
        clickText("Массаж")
        setElement(editBeginDataNews, "22.04.2023")
        setElement(editEndDataNews, "21.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("REFRESH")
        assertEquals(seeText("REFRESH"), true)

    }

    @Test
    fun editerCategoryGratitudeTest() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Благодарность")
        clickText("Благодарность")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("News")
        assertEquals(seeText("News"), true)

    }

    @Test
    fun editerCatigoryGratitudeDate1Test() {
        clickElement(listText)
        waitTextNewsFilter("Благодарность")
        clickText("Благодарность")
        setElement(editBeginDataNews, "23.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("Wrong period")
        assertEquals(seeText("Wrong period"), true)

    }

    @Test
    fun editerCatigoryGratitudeDate2Test() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Благодарность")
        clickText("Благодарность")
        setElement(editBeginDataNews, "22.04.2023")
        setElement(editEndDataNews, "21.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("REFRESH")
        assertEquals(seeText("REFRESH"), true)

    }

    @Test
    fun editerCategoryNeedHelpTest() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Нужна помощь")
        clickText("Нужна помощь")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("News")
        assertEquals(seeText("News"), true)

    }

    @Test
    fun editerCatigoryNeedHelpDate1Test() {
        clickElement(listText)
        waitTextNewsFilter("Нужна помощь")
        clickText("Нужна помощь")
        setElement(editBeginDataNews, "23.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("Wrong period")
        assertEquals(seeText("Wrong period"), true)

    }

    @Test
    fun editerCatigoryNeedHelpDate2Test() {
        waitElementNewsFilter(listText)
        clickElement(listText)
        waitTextNewsFilter("Нужна помощь")
        clickText("Нужна помощь")
        setElement(editBeginDataNews, "22.04.2023")
        setElement(editEndDataNews, "21.04.2023")
        clickElement(buttonSetFilter)
        waitTextNewsFilter("REFRESH")
        assertEquals(seeText("REFRESH"), true)

    }

}