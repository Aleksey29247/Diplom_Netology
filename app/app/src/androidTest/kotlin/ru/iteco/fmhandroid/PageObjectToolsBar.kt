package ru.iteco.fmhandroid

open class PageObjectToolsBar :ClassMain(){

    val buttonAuthorization = "authorization_image_button"
    val buttonMenu = "main_menu_image_button"

    val buttonProfel = "our_mission_image_button"
    val buttonExit = "title"


    fun initPage()
    {
        ClassMain()
    }
    fun buttonMenuClick()
    {
        getElement(buttonMenu).click()
        waitText("Main")
    }

    fun buttonClaimsClick()
    {
        getElement(buttonMenu).click()
        waitText("Claims")
        getText("Claims").click()
        waitText("Claims")
    }


    fun buttonNewsclick()
    {
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
        waitText("News")
    }

    fun buttonAboutClick()
    {
        getElement(buttonMenu).click()
        waitText("About")
        getText("About").click()
        waitText("Version:")
    }

    fun buttonLoginOutclick()
    {

        getElement(buttonAuthorization).click()
        waitElementAndroid(buttonExit)
        getElementAndroid(buttonExit).click()
        waitText("Authorization")

    }

    fun buttonProfel()
    {
        getElement(buttonProfel).click()
        waitText("Love is all")
    }

    fun clickImag(str: String)
    {
        getElement(str ).click()

    }

    fun result(text: String): Boolean
    {
        if  (returnText(text)==text){
        return true
        }
        return false
    }


}