package ru.iteco.fmhandroid;

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PageCreateNewsTest {
    val cm = ClassMain()
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
        cm.ClassMain()
        cm.getElement(buttonMenu).click()
        cm.waitText("News")
        cm.getText("News").click()
        cm.waitElement(editNews)
        cm.getElement(editNews).click()
        cm.waitElement(buttonAddNews)
        cm.getElement(buttonAddNews).click()
    }


    @Test
    fun SaveTestEmptyTest() {
        cm.getElement(buttonSave).click()
        cm.waitText("News")

    }

    @Test
    fun SaveFullPolesTest() {
        cm.getElement(listTypeNews).click()
        cm.waitText("Объявление")
        cm.getText("Объявление").click()
        cm.back()
        cm.waitElement(editPublicDateNews)
        cm.getElement(editPublicDateNews).click()
        cm.waitElementAndroid(buttonOk)
        cm.getElementAndroid(buttonOk).click()
        cm.waitElement(editPublicTimeNews)
        cm.getElement(editPublicTimeNews).click()
        cm.waitElementAndroid(buttonOk)
        cm.getElementAndroid(buttonOk).click()
        cm.waitElement(editDescriptText)
        cm.getElement(editDescriptText).text = "Мы рады"
        cm.getElement(buttonSave).click()
        cm.waitText("Объявление")
        assertEquals(cm.getText("Объявление").getText(), "Объявление")

    }

    @Test
    fun SaveFullPolesCategoryTest() {
        cm.getElement(listTypeNews).text = "war"
        cm.getElement(editText).text = "war"
        cm.waitElement(editPublicDateNews)
        cm.getElement(editPublicDateNews).click()
        cm.waitElementAndroid(buttonOk)
        cm.getElementAndroid(buttonOk).click()
        cm.waitElement(editPublicTimeNews)
        cm.getElement(editPublicTimeNews).click()
        cm.waitElementAndroid(buttonOk)
        cm.getElementAndroid(buttonOk).click()
        cm.waitElement(editDescriptText)
        cm.getElement(editDescriptText).text = "Мы рады"
        cm.getElement(buttonSave).click()
        cm.waitText("News")
        assertEquals(cm.getText("News").text, "News")
    }


}


