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
class CreatingClaimsTest {
    val cm = ClassMain()
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
        cm.ClassMain()
        cm.getElement(buttonMenu).click()
        cm.waitText("Claims")
        cm.getText("Claims").click()
        cm.waitElement(buttonAddClaims)
        cm.getElement(buttonAddClaims).click()
        cm.waitText("SAVE")
    }

    @Test
    fun titleEditText50CharTest() {
        cm.getElement(editTitle).text = "aaaaaaaasaasdaad"
        cm.getElement(buttonSave).click()
        cm.waitText("Fill empty fields")
        assertEquals(cm.getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun titleEditTextMore50CharTest() {
        cm.getElement(editTitle).text = char50
        cm.getElement(buttonSave).click()
        cm.waitText("Fill empty fields")
        assertEquals(cm.getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun titleEditText50CharRusTest() {
        cm.getElement(editTitle).text = "ааавы"
        cm.getElement(buttonSave).click()
        cm.waitText("Fill empty fields")
        assertEquals(cm.getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun titleEditTextMore50CharRusTest() {
        cm.getElement(editTitle).text = char50rus
        cm.getElement(buttonSave).click()
        cm.waitText("Fill empty fields")
        assertEquals(cm.getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun textInputPlaceholderTest() {
        cm.getElement(editException).click()
        cm.waitText(NameText)
        cm.getText(NameText).click()
        cm.waitElement(buttonSave)
        cm.getElement(buttonSave).click()
        cm.waitText("Fill empty fields")
        assertEquals(cm.getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun dataTest() {
        cm.getElement(editDataBegin).text = "01.07.1900"
        cm.getElement(buttonSave).click()
        cm.waitText("Fill empty fields")
        assertEquals(cm.getText("Fill empty fields").text, "Fill empty fields")
    }

    @Test
    fun timeTest() {
        cm.getElement(editTimeBegin).text = "20:00"
        cm.getElement(buttonSave).click()
        cm.waitText("Fill empty fields")
        assertEquals(cm.getText("Fill empty fields").text, "Fill empty fields")
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
        cm.getElement(editTimeBegin).text = timeText
        cm.getElement(buttonSave).click()
        cm.waitText("Fill empty fields")
        assertEquals(cm.getText("Fill empty fields").text, "Fill empty fields")
    }

}