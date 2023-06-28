package ru.iteco.fmhandroid;

import java.util.*

open class ClaimsCreatePageObject : ClassMain() {
    val buttonAddClaims = "add_new_claim_material_button"
    val buttonMenu = "main_menu_image_button"

    fun init() {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("Claims")
        getText("Claims").click()
        waitElement(buttonAddClaims)
        getElement(buttonAddClaims).click()
        waitText("SAVE")
    }

    fun setElementText(element: String, text: String) {
        getElement(element).text = text
    }

    fun clickElement(element: String) {
        getElement(element).click()
    }

    fun claimsCreateWaitText(text: String) {

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

    fun claimsCreateWaitElement(element: String) {
        waitElement(element)
    }

    fun realTimeMinus1Hours(): String {
        val date = Date()
        val hours = date.hours - 1
        val min = date.minutes
        var timeText: String
        if (min <= 9) {
            timeText = hours.toString() + ":0" + min.toString()
        } else {
            timeText = hours.toString() + ":" + min.toString()
        }
        return timeText
    }


}