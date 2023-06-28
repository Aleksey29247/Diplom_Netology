package ru.iteco.fmhandroid;

open class ControlPanelPageObject : ClassMain() {
    val buttonMenu = "main_menu_image_button"
    val buttonNews = "edit_news_material_button"
    val buttonFilter = "filter_news_material_button"


    fun init() {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
        waitElement(buttonNews)
        getElement(buttonNews).click()
        waitElement(buttonFilter)
        getElement(buttonFilter).click()
        waitText("Active")
        getText("Active").click()
        getText("Not active").click()
    }

    fun setTextElement(element: String, text: String) {
        getText(element).setText(text)
    }

    fun clickElement(clickElement: String) {
        getElement(clickElement).click()
    }

    fun controlPanelWaitText(text: String) {
        waitText(text)
    }

    fun textSee(text: String): Boolean {
        if (getText(text) != null)
            return true
        return false
    }

    fun setElementText(element: String, text: String) {
        getElement(element).text = text
    }

    fun clickElementAndroid(elementAndroid: String) {
        getElementAndroid(elementAndroid).click()
    }

    fun controlPanelWaitElementAndroid(elementAndroid: String) {
        waitElementAndroid(elementAndroid)
    }

    fun clickText(text: String) {
        getText(text).click()
    }

}