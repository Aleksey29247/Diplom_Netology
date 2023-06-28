package ru.iteco.fmhandroid;


open class NewsFilterPageObject : ClassMain() {
    val buttonMenu = "main_menu_image_button"
    val buttonFilter = "filter_news_material_button"
    fun init() {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
        waitElement(buttonFilter)
        getElement(buttonFilter).click()
    }

    fun setText(element: String, text: String) {
        getText(element).setText(text)
    }

    fun clickElement(element: String) {
        getElement(element).click()
    }

    fun waitTextNewsFilter(text: String) {
        waitText(text)
    }

    fun waitElementNewsFilter(element: String) {
        waitElement(element)
    }

    fun seeText(text: String): Boolean {
        if (getText(text) != null)
            return true
        return false
    }

    fun setElement(element: String, text: String) {
        getElement(element).setText(text)
    }

    fun clickText(text: String) {
        getText(text).click()
    }

}