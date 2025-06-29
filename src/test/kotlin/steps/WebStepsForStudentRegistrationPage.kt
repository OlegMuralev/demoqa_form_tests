package steps

import io.qameta.allure.Step
import pages.StudentRegistrationPage
import utils.StudentDataFactory

class WebStepsForStudentRegistrationPage {
    private val studentRegistrationPage = StudentRegistrationPage()
    private val student = StudentDataFactory.create()

    @Step("Открыть страницу формы регистрации студента")
    fun openStudentRegistrationForm() {
        studentRegistrationPage.openPageRemoveBanners()
    }

    @Step("Заполнить поле 'First Name' случайным значением")
    fun fillFirstName() {
        studentRegistrationPage.setFirstName(student.firstName)
    }
    @Step("Заполнить поле 'Last Name' случайным значением")
    fun fillLastName() {
        studentRegistrationPage.setLastName(student.lastName)
    }

    @Step("Заполнить поле 'Email' случайным значением")
    fun fillUserEmail() {
        studentRegistrationPage.setUserEmail(student.email)
    }

    @Step("Выбрать пол случайным образом")
    fun selectGender() {
        studentRegistrationPage.selectGender(student.gender)
    }
    @Step("Заполнить поле 'Mobile' случайным значением")
    fun setMobilePhone() {
        studentRegistrationPage.setMobilePhone(student.phone)
    }

    @Step("Заполнить поле 'Date Of Birth'")
    fun setDateOfBirth() {
        studentRegistrationPage.setDateOfBirth(student.dayOfBirth,student.monthOfBirth,student.yearOfBirth)
    }

    @Step("Заполнить поле 'Subjects' случайным значением")
    fun setSubject() {
        studentRegistrationPage.fillSubject(student.subject)
    }
}