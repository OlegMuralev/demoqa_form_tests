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
    @Step("Открыть страницу формы регистрации студента")
    fun openStudentRegistrationForm() {
        studentRegistrationPage.openPageRemoveBanners()
    }

    @Step("Заполнить поле 'First Name'")
    fun fillFirstName(firstName: String = student.firstName) {
        studentRegistrationPage.setFirstName(firstName)
    }

    @Step("Заполнить поле 'Last Name'")
    fun fillLastName(lastName: String = student.lastName) {
        studentRegistrationPage.setLastName(lastName)
    }

    @Step("Заполнить поле 'Email'")
    fun fillUserEmail(email: String = student.email) {
        studentRegistrationPage.setUserEmail(email)
    }

    @Step("Выбрать пол")
    fun selectGender(gender: Gender = student.gender) {
        studentRegistrationPage.selectGender(gender)
    }

    @Step("Заполнить поле 'Mobile'")
    fun setMobilePhone(phone: String = student.phone) {
        studentRegistrationPage.setMobilePhone(phone)
    }

    @Step("Заполнить поле 'Date Of Birth'")
    fun setDateOfBirth(
        dayOfBirth: String = student.dayOfBirth,
        monthOfBirth: String = student.monthOfBirth,
        yearOfBirth: String = student.yearOfBirth
    ) {
        studentRegistrationPage.setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
    }

    @Step("Заполнить поле 'Subjects'")
    fun setSubject(subject: String = student.subject) {
        studentRegistrationPage.fillSubject(subject)
    }

    @Step("Выбрать хобби")
    fun selectRandomHobbies(hobby: List<Hobby> = student.hobby) {
        studentRegistrationPage.selectHobbies(hobby)
    }

    @Step("Загрузить фото")
    fun uploadPhoto(photo: String = student.photo) {
        studentRegistrationPage.uploadPicture(photo)
    }

    @Step("Заполнить поле 'Current Address'")
    fun setCurrentAddress(address: String = student.address) {
        studentRegistrationPage.setCurrentAddress(address)
    }

    @Step("Выбрать область и город")
    fun setStateAndCity(state: String = student.state, city: String = student.city) {
        studentRegistrationPage.setStateAndCity(state, city)
    }

    @Step("Заполнить все поля в форме")
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

    @Step("Заполнить только обязательные поля в форме")
    fun fillMandatoryFieldsInTheForm() {
        fillFirstName()
        fillLastName()
        selectGender()
        setMobilePhone()
    }


    @Step("Нажать кнопку Submit и проверить открытие модального окна 'Thanks for submitting the form'")
    fun clickSubmitButtonAndCheckModalDialogAppears() {
        studentRegistrationPage.clickSubmitButton()
        thanksForSubmittingFormModalWindow.checkModalDialogAppear()
    }

    @Step("Нажать кнопку Submit и проверить, что валидация поле не прошла'")
    fun clickSubmitButtonExpectingValidationError() {
        studentRegistrationPage.clickSubmitButton()
        studentRegistrationPage.checkValidationFails()
        thanksForSubmittingFormModalWindow.checkModalDialogNotAppear()
    }

    @Step("Проверить, что поле 'Student Name' заполнено корректно")
    fun assertStudentName() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(
            label = "Student Name",
            value = "${student.firstName} ${student.lastName}"
        )
    }

    @Step("Проверить, что поле 'Student Email' заполнено корректно")
    fun assertStudentEmail(email: String = student.email) {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Student Email", value = email)
    }

    @Step("Проверить, что поле 'Gender' заполнено корректно")
    fun assertGender() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Gender", value = student.gender.displayedName)
    }

    @Step("Проверить, что поле 'Mobile' заполнено корректно")
    fun assertMobilePhone() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Mobile", value = student.phone)
    }

    @Step("Проверить, что поле 'Date of Birth' заполнено корректно")
    fun assertDateOfBirth() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(
            label = "Date of Birth",
            value = student.getFormattedDateOfBirth()
        )
    }

    @Step("Проверить, что поле 'Subjects' заполнено корректно")
    fun assertSubject() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Subjects", value = student.subject)
    }

    @Step("Проверить, что поле 'Hobbies' заполнено корректно")
    fun assertHobbies() {
        val hobbiesList: String = student.hobby.joinToString(", ") { it.displayedName }
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Hobbies", value = hobbiesList)
    }

    @Step("Проверить, что поле 'Picture' заполнено корректно")
    fun assertPicture() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Picture", value = student.photo)
    }

    @Step("Проверить, что поле 'State and City' заполнено корректно")
    fun assertStateAndCity() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(
            label = "State and City",
            value = "${student.state} ${student.city}"
        )
    }

    @Step("Нажать кнопку 'Close' в модальном окне 'Thanks for submitting the form'")
    fun clickCloseButton() {
        thanksForSubmittingFormModalWindow.clickCloseButton()
        thanksForSubmittingFormModalWindow.checkModalDialogDisappear()

    }
}