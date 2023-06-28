package ru.iteco.fmhandroid;


open class PageObjectAbout : ClassMain() {
    val buttonMenu = "main_menu_image_button"


    fun init() {
        ClassMain()
        getElement(buttonMenu).click();
        waitText("About")
        getText("About").click()
    }

    fun getBrowser(adress: String): Boolean {
        if (getElementChrome(adress) != null) {
            return true
        }
        return false
    }

    fun waitStartChrome(str: String) {
        waitElementChrome(str)
    }

    fun waitPages(textData: String) {
        waitText(textData)
    }

    fun clickToText(textToClick: String) {
        getText(textToClick).click()
    }


}