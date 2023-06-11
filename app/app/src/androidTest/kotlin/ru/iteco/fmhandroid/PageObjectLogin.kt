package ru.iteco.fmhandroid;

open class PageObjectLogin: ClassMain(){

    val buttonLogin = "enter_button"
    val textAuthorization = "Authorization"
    fun enterLogin(sLogin: String, sPassword: String)
    {
        getText("Login").setText(sLogin)
        getText("Password").setText(sPassword)
    }
    fun buttonClick()
    {
        getElement(buttonLogin).click()
    }
    fun login(): Boolean
    {
        if (returnText(textAuthorization)== textAuthorization)
        {
            return false;
        }
        if (returnText("News")=="News")
        {
            return true;
        }
        return false;
    }

}