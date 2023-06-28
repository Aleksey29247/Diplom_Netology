package ru.iteco.fmhandroid;

open class PagesNewsCreatePageObject:ClassMain(){

    val buttonMenu = "main_menu_image_button"
    val editNews = "edit_news_material_button"
    val buttonAddNews = "add_news_image_view"
    fun init()
    {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("News")
        getText("News").click()
        waitElement(editNews)
        getElement(editNews).click()
        waitElement(buttonAddNews)
        getElement(buttonAddNews).click()
    }

    fun clickElement(element:String)
    {
        getElement(element).click()
    }
    fun waitTextPagesNews(text:String)
    {
        waitText(text)
    }
    fun clickText(text:String)
    {
        getText(text).click()
    }

    fun setElement(element:String, text:String)
    {
        getElement(element).text = text
    }
    fun waitElementPagesNews(element:String)
    {
        waitElement(element)
    }
    fun waitElementAndroidPagesNew(element:String)
    {
        waitElementAndroid(element)
    }
    fun clickElementAndroid(element:String)
    {
       getElementAndroid(element).click()
    }
    fun seeText(text:String):Boolean
    {
        if (getText(text)!=null)
            return true
        return false
    }


}