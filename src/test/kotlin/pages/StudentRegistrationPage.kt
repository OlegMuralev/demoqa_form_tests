package pages

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.Selenide.`$` as s
import io.qameta.allure.Step
import com.codeborne.selenide.Condition.disappear

import java.time.Duration


object StudentRegistrationPage {
    private val firstNameInput = s("#firstName")
    private val lastNameInput = s("#lastName")
    private val userEmailInput = s("#userEmail")
    private val genderWrapper = s("#genterWrapper")
    private val userNumber = s("#userNumber")
    private val calendarInput = s("#dateOfBirthInput")
    private val subjectsInput = s("#subjectsInput")
    private val uploadPicture = s("#uploadPicture")
    private val hobbiesWrapper = s("#hobbiesWrapper")
    private val currentAddress = s("#currentAddress")
    private val submitButton = s("button#submit")


    @Step
    fun open() {
        open("/automation-practice-form")
    }
}