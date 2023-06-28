package ru.iteco.fmhandroid;


open class ClaimsPages : ClassMain() {
    fun install() {
        ClassMain()
        getElement("main_menu_image_button").click()
        waitText("Claims")
        getText("Claims").click()
        waitText("Claims")
        getElement("filters_material_button").click()
        waitText("Open")
        getText("Open").click()
        getText("In progress").click()
    }

    fun clickText(textToClick: String) {
        getText(textToClick).click()
    }

    fun clickElement(elementToClick: String) {
        getElement(elementToClick).click()
    }

    fun claimWaitElement(elemementWait: String) {
        waitElement(elemementWait)
    }

    fun claimsTextWait(textWait: String) {
        waitText(textWait)
    }

    fun textSee(text: String): Boolean {
        if (getText(text) != null)
            return true
        return false
    }

}