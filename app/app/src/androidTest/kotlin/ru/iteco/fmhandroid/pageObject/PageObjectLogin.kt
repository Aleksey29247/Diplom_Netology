package ru.iteco.fmhandroid;

open class PageObjectLogin : ClassMain() {
    val buttonLogin = "enter_button"
    val textAuthorization = "Authorization"
    var initStatus = 0


    fun initstalPage() {
        if (initStatus == 0) {
            intistal()
            initStatus = 1
        }
        wait15s("Authorization")
        if (textBool("Authorization") == false) {
            if (textBool("News") == false) {
                wait15s("News")
            } else {
                exitLogin()
            }
        } else {
            return
        }
        initstalPage()
    }


    fun exitLogin() {
        if (textBool("News") == true) {
            getElement("authorization_image_button").click();
            waitElementAndroid("title")
            getElementAndroid("title").click()
        }
    }

    fun enterLogin(sLogin: String, sPassword: String) {
        getText("Login").setText(sLogin)
        getText("Password").setText(sPassword)
    }

    fun buttonClick() {
        getElement(buttonLogin).click()
    }

    fun login(): Boolean {
        if (returnText(textAuthorization) == textAuthorization) {
            return false;
        }
        if (returnText("News") == "News") {
            return true;
        }
        return false;
    }

}