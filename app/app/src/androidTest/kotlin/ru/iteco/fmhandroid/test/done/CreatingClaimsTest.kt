package ru.iteco.fmhandroid.test.done;
///ok
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ClaimsCreatePageObject
import java.util.*

@RunWith(AndroidJUnit4::class)
class CreatingClaimsTest : ClaimsCreatePageObject() {


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
        init()
    }

    @Test
    fun titleEditText50CharTest() {
        setElementText(editTitle, "aaaaaaaasaasdaad")
        clickElement(buttonSave)
        claimsCreateWaitText("Fill empty fields")
        assertEquals(textSee("Fill empty fields"), true)
    }

    @Test
    fun titleEditTextMore50CharTest() {
        setElementText((editTitle), text = char50)
        clickElement(buttonSave)
        claimsCreateWaitText("Fill empty fields")
        assertEquals(textSee("Fill empty fields"), true)

    }

    @Test
    fun titleEditText50CharRusTest() {
        setElementText(editTitle, "ааавы")
        clickElement(buttonSave)
        claimsCreateWaitText("Fill empty fields")
        assertEquals(textSee("Fill empty fields"), true)

    }

    @Test
    fun titleEditTextMore50CharRusTest() {
        setElementText((editTitle), text = char50rus)
        clickElement(buttonSave)
        claimsCreateWaitText("Fill empty fields")
        assertEquals(textSee("Fill empty fields"), true)

    }

    @Test
    fun textInputPlaceholderTest() {
        clickElement(editException)
        claimsCreateWaitText(NameText)
        clickText(NameText)
        claimsCreateWaitElement(buttonSave)
        clickElement(buttonSave)
        claimsCreateWaitText("Fill empty fields")
        assertEquals(textSee("Fill empty fields"), true)

    }

    @Test
    fun dataTest() {
        setElementText(editDataBegin, "01.07.1900")
        clickElement(buttonSave)
        claimsCreateWaitText("Fill empty fields")
        assertEquals(textSee("Fill empty fields"), true)

    }

    @Test
    fun timeTest() {
        setElementText(editTimeBegin, "20:00")
        clickElement(buttonSave)
        claimsCreateWaitText("Fill empty fields")
        assertEquals(textSee("Fill empty fields"), true)

    }

    @Test
    fun timeBack1HTest() {
        setElementText(editTimeBegin, realTimeMinus1Hours())
        clickElement(buttonSave)
        claimsCreateWaitText("Fill empty fields")
        assertEquals(textSee("Fill empty fields"), true)

    }

}