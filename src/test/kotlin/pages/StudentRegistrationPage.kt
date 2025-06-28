package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.sleep
import io.qameta.allure.Step
import utils.Calendar
import utils.Gender
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
    private val submitButton = s("button#submit")

    var calendar: Calendar = Calendar()

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
        calendar.setDate(day, month, year)
    }

}