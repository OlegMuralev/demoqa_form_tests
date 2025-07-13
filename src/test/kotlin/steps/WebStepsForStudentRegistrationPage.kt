package steps

import enums.Gender
import enums.Hobby
import io.qameta.allure.Step
import pages.StudentRegistrationPage
import pages.ThanksForSubmittingFormModalWindow
import utils.StudentData

class WebStepsForStudentRegistrationPage(
    private val student: StudentData,
    private val studentRegistrationPage: StudentRegistrationPage = StudentRegistrationPage(),
    private val thanksForSubmittingFormModalWindow: ThanksForSubmittingFormModalWindow = ThanksForSubmittingFormModalWindow()
) {
    @Step("Open the student registration form page")
    fun openStudentRegistrationForm() {
        studentRegistrationPage.openPageRemoveBanners()
    }

    @Step("Fill in the 'First Name' field")
    fun fillFirstName(firstName: String = student.firstName) {
        studentRegistrationPage.setFirstName(firstName)
    }

    @Step("Fill in the 'Last Name' field")
    fun fillLastName(lastName: String = student.lastName) {
        studentRegistrationPage.setLastName(lastName)
    }

    @Step("Fill in the 'Email' field")
    fun fillUserEmail(email: String = student.email) {
        studentRegistrationPage.setUserEmail(email)
    }

    @Step("Select gender")
    fun selectGender(gender: Gender = student.gender) {
        studentRegistrationPage.selectGender(gender)
    }

    @Step("Fill in the 'Mobile' field")
    fun setMobilePhone(phone: String = student.phone) {
        studentRegistrationPage.setMobilePhone(phone)
    }

    @Step("Fill in the 'Date Of Birth' field")
    fun setDateOfBirth(
        dayOfBirth: String = student.dayOfBirth,
        monthOfBirth: String = student.monthOfBirth,
        yearOfBirth: String = student.yearOfBirth
    ) {
        studentRegistrationPage.setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
    }

    @Step("Fill in the 'Subjects' field")
    fun setSubject(subject: String = student.subject) {
        studentRegistrationPage.fillSubject(subject)
    }

    @Step("Select hobbies")
    fun selectRandomHobbies(hobby: List<Hobby> = student.hobby) {
        studentRegistrationPage.selectHobbies(hobby)
    }

    @Step("Upload photo")
    fun uploadPhoto(photo: String = student.photo) {
        studentRegistrationPage.uploadPicture(photo)
    }

    @Step("Fill in the 'Current Address' field")
    fun setCurrentAddress(address: String = student.address) {
        studentRegistrationPage.setCurrentAddress(address)
    }

    @Step("Select state and city")
    fun setStateAndCity(state: String = student.state, city: String = student.city) {
        studentRegistrationPage.setStateAndCity(state, city)
    }

    @Step("Fill in all fields in the form")
    fun fillAllFieldsInTheForm() {
        fillFirstName()
        fillLastName()
        fillUserEmail()
        selectGender()
        setMobilePhone()
        setDateOfBirth()
        setSubject()
        selectRandomHobbies()
        uploadPhoto()
        setCurrentAddress()
        setStateAndCity()
    }

    @Step("Fill in only mandatory fields in the form")
    fun fillMandatoryFieldsInTheForm() {
        fillFirstName()
        fillLastName()
        selectGender()
        setMobilePhone()
    }

    @Step("Click the Submit button and check that the 'Thanks for submitting the form' modal window appears")
    fun clickSubmitButtonAndCheckModalDialogAppears() {
        studentRegistrationPage.clickSubmitButton()
        thanksForSubmittingFormModalWindow.checkModalDialogAppear()
    }

    @Step("Click the Submit button and check that the field validation failed")
    fun clickSubmitButtonExpectingValidationError() {
        studentRegistrationPage.clickSubmitButton()
        studentRegistrationPage.checkValidationFails()
        thanksForSubmittingFormModalWindow.checkModalDialogNotAppear()
    }

    @Step("Verify that the 'Student Name' field is filled in correctly")
    fun assertStudentName() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(
            label = "Student Name",
            value = "${student.firstName} ${student.lastName}"
        )
    }

    @Step("Verify that the 'Student Email' field is filled in correctly")
    fun assertStudentEmail(email: String = student.email) {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Student Email", value = email)
    }

    @Step("Verify that the 'Gender' field is filled in correctly")
    fun assertGender() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Gender", value = student.gender.displayedName)
    }

    @Step("Verify that the 'Mobile' field is filled in correctly")
    fun assertMobilePhone() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Mobile", value = student.phone)
    }

    @Step("Verify that the 'Date of Birth' field is filled in correctly")
    fun assertDateOfBirth() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(
            label = "Date of Birth",
            value = student.getFormattedDateOfBirth()
        )
    }

    @Step("Verify that the 'Subjects' field is filled in correctly")
    fun assertSubject() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Subjects", value = student.subject)
    }

    @Step("Verify that the 'Hobbies' field is filled in correctly")
    fun assertHobbies() {
        val hobbiesList: String = student.hobby.joinToString(", ") { it.displayedName }
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Hobbies", value = hobbiesList)
    }

    @Step("Verify that the 'Picture' field is filled in correctly")
    fun assertPicture() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Picture", value = student.photo)
    }

    @Step("Verify that the 'State and City' field is filled in correctly")
    fun assertStateAndCity() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(
            label = "State and City",
            value = "${student.state} ${student.city}"
        )
    }

    @Step("Click the 'Close' button in the 'Thanks for submitting the form' modal window")
    fun clickCloseButton() {
        thanksForSubmittingFormModalWindow.clickCloseButton()
        thanksForSubmittingFormModalWindow.checkModalDialogDisappear()
    }
}
