package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.sleep
import io.qameta.allure.Step
import utils.CalendarComponent
import enums.Gender
import enums.Hobby
import java.time.Duration
import com.codeborne.selenide.Selenide.`$` as s


class StudentRegistrationPage {
    private val firstNameInput = s("#firstName")
    private val lastNameInput = s("#lastName")
    private val userEmailInput = s("#userEmail")
    private val genderWrapper = s("#genterWrapper")
    private val userMobilePhone = s("#userNumber")
    private val calendarInput = s("#dateOfBirthInput")
    private val subjectsInput = s("#subjectsInput")
    private val uploadPicture = s("#uploadPicture")
    private val hobbiesWrapper = s("#hobbiesWrapper")
    private val currentAddress = s("#currentAddress")
    private val stateDropDown = s("#react-select-3-input")
    private val cityDropDown = s("#react-select-4-input")
    private val submitButton = s("button#submit")

    private val calendarComponent: CalendarComponent = CalendarComponent()

    @Step
    fun openPageRemoveBanners(): StudentRegistrationPage {
        return openPage()
            .removeBanners()
            .waitForAdToDisappear()
    }

    private fun openPage(): StudentRegistrationPage {
        open("/automation-practice-form")
        return this
    }

    private fun removeBanners(): StudentRegistrationPage {
        sleep(2000)
        Selenide.executeJavaScript<Any>("$('#fixedban').remove();")
        Selenide.executeJavaScript<Any>("$('footer').remove();")
        Selenide.executeJavaScript<Any>("$('iframe').remove();")
        return this
    }

    private fun waitForAdToDisappear(): StudentRegistrationPage {
        Selenide.`$`("#fixedban").should(Condition.disappear, Duration.ofSeconds(5))
        Selenide.`$`("footer").should(Condition.disappear, Duration.ofSeconds(5))
        return this
    }

    fun setFirstName(name : String) {
        firstNameInput.setValue(name)
    }

    fun setLastName(lastname : String) {
        lastNameInput.setValue(lastname)
    }

    fun setUserEmail(email : String) {
        userEmailInput.setValue(email)
    }

    fun selectGender(gender: Gender) {
        genderWrapper.`$x`(".//label[text()='${gender.displayedName}']").click()
    }

    fun setMobilePhone(phone : String) {
        userMobilePhone.setValue(phone)
    }

    fun setDateOfBirth(day : String, month : String, year : String) {
        calendarInput.click()

        calendarComponent.setDate(day, month, year)
    }

    fun fillSubject(subject : String) {
        subjectsInput.click()
        subjectsInput.setValue(subject).pressEnter()
    }

    fun selectHobbies(hobbies : List<Hobby>) {
        hobbies.forEach { hobby ->
            hobbiesWrapper.`$x`(".//label[text()='${hobby.displayedName}']").click()
        }
    }

    fun uploadPicture(pathToFile : String) {
        uploadPicture.uploadFromClasspath(pathToFile)
    }

    fun setCurrentAddress(address : String) {
        currentAddress.setValue(address)
    }

    fun setStateAndCity(state : String, city : String) {
        stateDropDown.setValue(state).pressEnter()
        cityDropDown.setValue(city).pressEnter()
    }

    fun clickSubmitButton() {
        submitButton.click()
    }
}