package ru.iteco.fmhandroid;

open class NewsPagesPageObject : ClassMain() {
    val buttonMenu = "main_menu_image_button"
    fun init() {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
    }


    fun seeText(text: String): Boolean {
        if (getText(text) != null)
            return true
        return false
    }

    fun waitTextNewsPages(text: String) {
        waitText(text)
    }

    fun clickElement(element: String) {
        getElement(element).click()
    }

}