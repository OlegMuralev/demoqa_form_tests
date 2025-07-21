package steps

import enums.Gender
import enums.Hobby
import io.qameta.allure.Step
import pages.StudentRegistrationPage
import pages.ThanksForSubmittingFormModalWindow
import utils.StudentData
import utils.Log

class WebStepsForStudentRegistrationPage(
    private val student: StudentData,
    private val studentRegistrationPage: StudentRegistrationPage = StudentRegistrationPage(),
    private val thanksForSubmittingFormModalWindow: ThanksForSubmittingFormModalWindow = ThanksForSubmittingFormModalWindow(),
    private val log: Log = Log()
) {

    @Step("Open the student registration form page")
    fun openStudentRegistrationForm() {
        log.printLog("Opening student registration form")
        studentRegistrationPage.openPageRemoveBanners()
    }

    @Step("Fill in the 'First Name' field")
    fun fillFirstName(firstName: String = student.firstName) {
        log.printLog("Filling first name: $firstName")
        studentRegistrationPage.setFirstName(firstName)
    }

    @Step("Fill in the 'Last Name' field")
    fun fillLastName(lastName: String = student.lastName) {
        log.printLog("Filling last name: $lastName")
        studentRegistrationPage.setLastName(lastName)
    }

    @Step("Fill in the 'Email' field")
    fun fillUserEmail(email: String = student.email) {
        log.printLog("Filling email: $email")
        studentRegistrationPage.setUserEmail(email)
    }

    @Step("Select gender")
    fun selectGender(gender: Gender = student.gender) {
        log.printLog("Selecting gender: ${gender.displayedName}")
        studentRegistrationPage.selectGender(gender)
    }

    @Step("Fill in the 'Mobile' field")
    fun setMobilePhone(phone: String = student.phone) {
        log.printLog("Filling mobile phone: $phone")
        studentRegistrationPage.setMobilePhone(phone)
    }

    @Step("Fill in the 'Date Of Birth' field")
    fun setDateOfBirth(
        dayOfBirth: String = student.dayOfBirth,
        monthOfBirth: String = student.monthOfBirth,
        yearOfBirth: String = student.yearOfBirth
    ) {
        log.printLog("Setting date of birth: $dayOfBirth $monthOfBirth, $yearOfBirth")
        studentRegistrationPage.setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
    }

    @Step("Fill in the 'Subjects' field")
    fun setSubject(subject: String = student.subject) {
        log.printLog("Filling subject: $subject")
        studentRegistrationPage.fillSubject(subject)
    }

    @Step("Select hobbies")
    fun selectRandomHobbies(hobby: List<Hobby> = student.hobby) {
        val hobbiesList = hobby.joinToString(", ") { it.displayedName }
        log.printLog("Selecting hobbies: $hobbiesList")
        studentRegistrationPage.selectHobbies(hobby)
    }

    @Step("Upload photo")
    fun uploadPhoto(photo: String = student.photo) {
        log.printLog("Uploading photo: $photo")
        studentRegistrationPage.uploadPicture(photo)
    }

    @Step("Fill in the 'Current Address' field")
    fun setCurrentAddress(address: String = student.address) {
        log.printLog("Filling address: $address")
        studentRegistrationPage.setCurrentAddress(address)
    }

    @Step("Select state and city")
    fun setStateAndCity(state: String = student.state, city: String = student.city) {
        log.printLog("Selecting state and city: $state, $city")
        studentRegistrationPage.setStateAndCity(state, city)
    }

    @Step("Fill in all fields in the form")
    fun fillAllFieldsInTheForm() {
        log.printLog("Filling all fields")
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
        log.printLog("Filling only mandatory fields")
        fillFirstName()
        fillLastName()
        selectGender()
        setMobilePhone()
    }

    @Step("Click the Submit button and check that the 'Thanks for submitting the form' modal window appears")
    fun clickSubmitButtonAndCheckModalDialogAppears() {
        log.printLog("Clicking submit button and checking modal appears")
        studentRegistrationPage.clickSubmitButton()
        thanksForSubmittingFormModalWindow.checkModalDialogAppear()
    }

    @Step("Click the Submit button and check that the field validation failed")
    fun clickSubmitButtonExpectingValidationError() {
        log.printLog("Clicking submit expecting validation error")
        studentRegistrationPage.clickSubmitButton()
        studentRegistrationPage.checkValidationFails()
        thanksForSubmittingFormModalWindow.checkModalDialogNotAppear()
    }

    @Step("Verify that the 'Student Name' field is filled in correctly")
    fun assertStudentName() {
        val fullName = "${student.firstName} ${student.lastName}"
        log.printLog("Asserting student name: $fullName")
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Student Name", value = fullName)
    }

    @Step("Verify that the 'Student Email' field is filled in correctly")
    fun assertStudentEmail(email: String = student.email) {
        log.printLog("Asserting student email: $email")
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Student Email", value = email)
    }

    @Step("Verify that the 'Gender' field is filled in correctly")
    fun assertGender() {
        log.printLog("Asserting gender: ${student.gender.displayedName}")
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Gender", value = student.gender.displayedName)
    }

    @Step("Verify that the 'Mobile' field is filled in correctly")
    fun assertMobilePhone() {
        log.printLog("Asserting mobile phone: ${student.phone}")
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Mobile", value = student.phone)
    }

    @Step("Verify that the 'Date of Birth' field is filled in correctly")
    fun assertDateOfBirth() {
        val dob = student.getFormattedDateOfBirth()
        log.printLog("Asserting date of birth: $dob")
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Date of Birth", value = dob)
    }

    @Step("Verify that the 'Subjects' field is filled in correctly")
    fun assertSubject() {
        log.printLog("Asserting subject: ${student.subject}")
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Subjects", value = student.subject)
    }

    @Step("Verify that the 'Hobbies' field is filled in correctly")
    fun assertHobbies() {
        val hobbiesList: String = student.hobby.joinToString(", ") { it.displayedName }
        log.printLog("Asserting hobbies: $hobbiesList")
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Hobbies", value = hobbiesList)
    }

    @Step("Verify that the 'Picture' field is filled in correctly")
    fun assertPicture() {
        log.printLog("Asserting picture: ${student.photo}")
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Picture", value = student.photo)
    }

    @Step("Verify that the 'State and City' field is filled in correctly")
    fun assertStateAndCity() {
        val location = "${student.state} ${student.city}"
        log.printLog("Asserting state and city: $location")
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "State and City", value = location)
    }

    @Step("Click the 'Close' button in the 'Thanks for submitting the form' modal window")
    fun clickCloseButton() {
        log.printLog("Clicking close button on modal")
        thanksForSubmittingFormModalWindow.clickCloseButton()
        thanksForSubmittingFormModalWindow.checkModalDialogDisappear()
    }
}