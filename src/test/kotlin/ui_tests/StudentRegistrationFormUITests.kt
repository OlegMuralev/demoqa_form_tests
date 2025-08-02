package ui_tests

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import steps.StudentRegistrationSteps
import steps.WebStepsForStudentRegistrationPage
import steps.WebStudentRegistrationSteps
import utils.StudentData
import utils.StudentDataFactory
import java.util.stream.Stream


class StudentRegistrationFormUITests : TestBase() {

    companion object {
        @JvmStatic
        fun studentDataProvider(): Stream<StudentData> {
            return Stream.of(
                StudentDataFactory.create(),
                StudentDataFactory.create()
            )
        }

        @JvmStatic
        fun invalidEmailProvider(): Stream<String> {
            return Stream.of(
                "plainaddress",
                "@missingusername.com",
                "username@.com",
                "username@.com.",
                "username@domain..com",
                "username@domain,com",
                "username@domain com"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("studentDataProvider")
    @DisplayName("Check filling all registration form fields with valid data")
    fun testFillAllFieldsOfTheRegistrationForm(student: StudentData) {
        val steps: StudentRegistrationSteps = WebStudentRegistrationSteps(WebStepsForStudentRegistrationPage(student))

        steps.openForm()
        steps.fillAllFields()
        steps.submitExpectSuccess()
        steps.verifyAllFields()
        steps.closeModal()
    }

    @ParameterizedTest
    @MethodSource("invalidEmailProvider")
    @DisplayName("Check filling form with invalid email -> error received, then corrected -> success")
    fun testFillRegistrationFormWithInvalidEmail(invalidEmail: String) {
        val validEmail = "student1@example.com"
        val studentWithInvalidEmail = StudentDataFactory.create().copy(email = invalidEmail)
        val steps = WebStepsForStudentRegistrationPage(studentWithInvalidEmail)

        steps.openStudentRegistrationForm()
        steps.fillAllFieldsInTheForm()
        steps.clickSubmitButtonExpectingValidationError()
        steps.fillUserEmail(email = validEmail)
        steps.clickSubmitButtonAndCheckModalDialogAppears()
        steps.assertStudentEmail(email = validEmail)
    }

    @ParameterizedTest
    @MethodSource("studentDataProvider")
    @DisplayName("Check filling only mandatory fields in the form")
    fun fillMandatoryFieldsInTheForm(student: StudentData) {
        val steps = WebStepsForStudentRegistrationPage(student)
        steps.openStudentRegistrationForm()
        steps.fillMandatoryFieldsInTheForm()
        steps.clickSubmitButtonAndCheckModalDialogAppears()
    }
}
