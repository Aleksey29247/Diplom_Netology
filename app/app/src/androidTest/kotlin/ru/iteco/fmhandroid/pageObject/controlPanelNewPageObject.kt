package ru.iteco.fmhandroid;

open class ControlPanelNewPageObject : ClassMain() {
    val buttonMenu = "main_menu_image_button"
    val buttonNews = "edit_news_material_button"
    fun init() {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
        waitElement(buttonNews)
        getElement(buttonNews).click()
        waitText("ACTIVE")

    }

    fun clickElement(element: String) {
        getElement(element).click()
    }

    fun controlPanelNewWaitElement(element: String) {
        waitElement(element)
    }

    fun conrolPanelNewWaitText(text: String) {
        waitText(text)
    }

    fun textSee(text: String): Boolean {
        if (getText(text) != null)
            return true
        return false
    }

    fun clickText(text: String) {
        getText(text).click()
    }


}