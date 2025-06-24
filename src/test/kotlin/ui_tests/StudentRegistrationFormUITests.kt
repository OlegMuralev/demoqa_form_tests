package ui_tests

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import steps.WebStepsForStudentRegistrationPage

class StudentRegistrationFormUITests: TestBase() {
    private val steps = WebStepsForStudentRegistrationPage()
    @Test
    @DisplayName("Проверка заполнения всех полей формы регистрации")
    fun testFillAllFieldsOfTheRegistrationForm() {
        steps.openStudentRegistrationForm()
        steps.setFirstName()
    }

}