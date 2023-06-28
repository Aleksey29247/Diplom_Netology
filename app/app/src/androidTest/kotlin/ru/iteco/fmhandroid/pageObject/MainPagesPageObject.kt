package ru.iteco.fmhandroid;


open class MainPagesPageObject : ClassMain() {

    fun clickElement(element: String) {
        getElement(element).click()
    }

    fun waitElementMainPages(element: String) {
        waitElement(element)
    }

    fun waitTextMainPages(text: String) {
        waitText(text)
    }

    fun seeText(text: String): Boolean {
        if (getText(text) != null)
            return true
        return false
    }


}