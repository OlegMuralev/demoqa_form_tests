package ui_tests

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import steps.WebStepsForStudentRegistrationPage
import utils.StudentDataFactory

class StudentRegistrationFormUITests: TestBase() {

    @Test
    @DisplayName("Check filling all registration form fields with valid data")
    fun testFillAllFieldsOfTheRegistrationForm() {
        val student = StudentDataFactory.create()
        val steps = WebStepsForStudentRegistrationPage(student)

        steps.openStudentRegistrationForm()
        steps.fillAllFieldsInTheForm()
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
    @DisplayName("Check filling form with invalid email -> error received, then corrected -> success")
    fun testFillRegistrationFormWithInvalidEmail() {
        val validEmail = "student1@example.com"
        val invalidEmail = "bad-email"
        val studentWithInvalidEmail = StudentDataFactory.create().copy(email = invalidEmail)
        val steps = WebStepsForStudentRegistrationPage(studentWithInvalidEmail)

        steps.openStudentRegistrationForm()
        steps.fillAllFieldsInTheForm()
        steps.clickSubmitButtonExpectingValidationError()
        steps.fillUserEmail(email = validEmail)
        steps.clickSubmitButtonAndCheckModalDialogAppears()
        steps.assertStudentEmail(email = validEmail)
    }

    @Test
    @DisplayName("Check filling only mandatory fields in the form")
    fun fillMandatoryFieldsInTheForm() {
        val student = StudentDataFactory.create()
        val steps = WebStepsForStudentRegistrationPage(student)
        steps.openStudentRegistrationForm()
        steps.fillMandatoryFieldsInTheForm()
    }
}
