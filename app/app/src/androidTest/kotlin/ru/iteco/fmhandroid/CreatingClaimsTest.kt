package ru.iteco.fmhandroid;
///ok
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*
import ru.iteco.fmhandroid.ClassMain

@RunWith(AndroidJUnit4::class)
class CreatingClaimsTest : ClassMain(){
    val buttonMenu = "main_menu_image_button"
    val buttonAddClaims = "add_new_claim_material_button"
    val editTitle = "title_edit_text"
    val buttonSave = "save_button"
    val editException = "text_input_end_icon"
    val NameText = "Ivanov Ivan Ivanovich"
    val editDataBegin = "date_in_plan_text_input_edit_text"
    val editTimeBegin = "time_in_plan_text_input_edit_text"
    val char50 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    val char50rus = "ввввввввввыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыыы"

    @Before
    fun PagesCreate() {
        ClassMain()
        getElement(buttonMenu).click()
        waitText("Claims")
        getText("Claims").click()
        waitElement(buttonAddClaims)
        getElement(buttonAddClaims).click()
        waitText("SAVE")
    }

    @Test
    fun titleEditText50CharTest() {
        getElement(editTitle).text = "aaaaaaaasaasdaad"
        getElement(buttonSave).click()
        waitText("Fill empty fields")
        assertEquals(getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun titleEditTextMore50CharTest() {
        getElement(editTitle).text = char50
        getElement(buttonSave).click()
        waitText("Fill empty fields")
        assertEquals(getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun titleEditText50CharRusTest() {
        getElement(editTitle).text = "ааавы"
        getElement(buttonSave).click()
        waitText("Fill empty fields")
        assertEquals(getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun titleEditTextMore50CharRusTest() {
        getElement(editTitle).text = char50rus
        getElement(buttonSave).click()
        waitText("Fill empty fields")
        assertEquals(getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun textInputPlaceholderTest() {
        getElement(editException).click()
        waitText(NameText)
        getText(NameText).click()
        waitElement(buttonSave)
        getElement(buttonSave).click()
        waitText("Fill empty fields")
        assertEquals(getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun dataTest() {
        getElement(editDataBegin).text = "01.07.1900"
        getElement(buttonSave).click()
        waitText("Fill empty fields")
        assertEquals(getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun timeTest() {
        getElement(editTimeBegin).text = "20:00"
        getElement(buttonSave).click()
        waitText("Fill empty fields")
        assertEquals(getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun timeBack1HTest() {
        val date = Date()
        val hours = date.hours - 1
        val min = date.minutes
        var timeText: String
        if (min <= 9) {
            timeText = hours.toString() + ":0" + min.toString()
        } else {
            timeText = hours.toString() + ":" + min.toString()
        }
        getElement(editTimeBegin).text = timeText
        getElement(buttonSave).click()
        waitText("Fill empty fields")
        assertEquals(getText("Fill empty fields").text, "Fill empty fields")
    }

}