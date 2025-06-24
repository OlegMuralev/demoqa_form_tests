package steps

import io.qameta.allure.Step
import pages.StudentRegistrationPage

class WebStepsForStudentRegistrationPage {
    private val studentRegistrationPage = StudentRegistrationPage()
    @Step("Открыть страницу формы регистрации студента")
    fun openStudentRegistrationForm() {
        studentRegistrationPage.openPageRemoveBanners()
    }

    @Step("Заполнить поле 'First Name' случайным значением")
    fun setFirstName() {
        studentRegistrationPage.setFirstName("name")
    }
}