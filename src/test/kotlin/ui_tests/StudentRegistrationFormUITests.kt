package ui_tests

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import steps.WebStepsForStudentRegistrationPage
import utils.StudentDataFactory

class StudentRegistrationFormUITests: TestBase() {

    @Test
    @DisplayName("Проверка заполнения всех полей формы регистрации валидными данными")
    fun testFillAllFieldsOfTheRegistrationForm() {
        val student = StudentDataFactory.create()
        val steps = WebStepsForStudentRegistrationPage(student)

        steps.openStudentRegistrationForm()
        steps.fillFirstName()
        steps.fillLastName()
        steps.fillUserEmail()
        steps.selectGender()
        steps.setMobilePhone()
        steps.setDateOfBirth()
        steps.setSubject()
        steps.selectRandomHobbies()
        steps.uploadPhoto()
        steps.setCurrentAddress()
        steps.setStateAndCity()
        steps.clickSubmitButtonAndCheckModalDialogAppears()

        steps.assertStudentName()
        steps.assertStudentEmail()
        steps.assertGender()
        steps.assertMobilePhone()
        steps.assertDateOfBirth()
        steps.assertSubject()
        steps.assertHobbies()
        steps.assertPicture()
        steps.assertStateAndCity()
        steps.clickCloseButton()
    }

    @Test
    @DisplayName("Проверка заполнения формы c невалидным Email")
    fun testFillRegistrationFormWithInvalidEmail() {
        val studentWithInvalidEmail = StudentDataFactory.createWithInvalidEmail()
        val steps = WebStepsForStudentRegistrationPage(studentWithInvalidEmail)

        steps.openStudentRegistrationForm()
        steps.fillFirstName()
        steps.fillLastName()
        steps.fillUserEmail()
        steps.selectGender()
        steps.setMobilePhone()
        steps.setDateOfBirth()
        steps.setSubject()
        steps.selectRandomHobbies()
        steps.uploadPhoto()
        steps.setCurrentAddress()
        steps.setStateAndCity()
        steps.clickSubmitButtonExpectingValidationError()
    }
}