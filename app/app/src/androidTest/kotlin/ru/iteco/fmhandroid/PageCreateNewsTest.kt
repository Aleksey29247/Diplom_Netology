package ru.iteco.fmhandroid;

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PageCreateNewsTest : ClassMain(){
    val buttonMenu = "main_menu_image_button"
    val editNews = "edit_news_material_button"
    val buttonAddNews = "add_news_image_view"
    val buttonSave = "save_button"
    val editText = "news_item_title_text_input_edit_text"
    val listTypeNews = "news_item_category_text_auto_complete_text_view"
    val editPublicDateNews = "news_item_publish_date_text_input_edit_text"
    val editPublicTimeNews = "news_item_publish_time_text_input_edit_text"
    val editDescriptText = "news_item_description_text_input_edit_text"
    val buttonOk = "button1"

    @Before
    fun PagesNewsCreate() {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
        waitElement(editNews)
        getElement(editNews).click()
        waitElement(buttonAddNews)
        getElement(buttonAddNews).click()
    }

    @Test
    fun SaveTestEmptyTest() {
        getElement(buttonSave).click()
        waitText("News")

    }

    @Test
    fun SaveFullPolesTest() {
        getElement(listTypeNews).click()
        waitText("Объявление")
        getText("Объявление").click()
        back()
        waitElement(editPublicDateNews)
        getElement(editPublicDateNews).click()
        waitElementAndroid(buttonOk)
        getElementAndroid(buttonOk).click()
        waitElement(editPublicTimeNews)
        getElement(editPublicTimeNews).click()
        waitElementAndroid(buttonOk)
        getElementAndroid(buttonOk).click()
        waitElement(editDescriptText)
        getElement(editDescriptText).text = "Мы рады"
        getElement(buttonSave).click()
        waitText("Объявление")
        assertEquals(getText("Объявление").getText(), "Объявление")

    }

    @Test
    fun SaveFullPolesCategoryTest() {
        getElement(listTypeNews).text = "war"
        getElement(editText).text = "war"
        waitElement(editPublicDateNews)
        getElement(editPublicDateNews).click()
        waitElementAndroid(buttonOk)
        getElementAndroid(buttonOk).click()
        waitElement(editPublicTimeNews)
        getElement(editPublicTimeNews).click()
        waitElementAndroid(buttonOk)
        getElementAndroid(buttonOk).click()
        waitElement(editDescriptText)
        getElement(editDescriptText).text = "Мы рады"
        getElement(buttonSave).click()
        waitText("News")
        assertEquals(getText("News").text, "News")
    }


}


