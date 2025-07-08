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
    @DisplayName("Проверка заполнения формы c невалидным Email -> получили ошибку, заполнили корректным email -> успех")
    fun testFillRegistrationFormWithInvalidEmail() {
        val validEmail = "student1@example.com"
        val invalidEmail = "bad-email"
        val studentWithInvalidEmail = StudentDataFactory.create().copy(email = invalidEmail)
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
        steps.fillUserEmail(email = validEmail)
        steps.clickSubmitButtonAndCheckModalDialogAppears()
        steps.assertStudentEmail(email = validEmail)
    }
}