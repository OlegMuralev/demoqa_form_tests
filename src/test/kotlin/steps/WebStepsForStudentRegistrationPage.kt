package steps

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

    @Step("Заполнить поле 'First Name' случайным значением")
    fun fillFirstName() {
        studentRegistrationPage.setFirstName(student.firstName)
    }

    @Step("Заполнить поле 'Last Name' случайным значением")
    fun fillLastName() {
        studentRegistrationPage.setLastName(student.lastName)
    }

    @Step("Заполнить поле 'Email' случайным значением")
    fun fillUserEmail(email: String = student.email) {
        studentRegistrationPage.setUserEmail(email)
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
        studentRegistrationPage.setDateOfBirth(student.dayOfBirth, student.monthOfBirth, student.yearOfBirth)
    }

    @Step("Заполнить поле 'Subjects' случайным значением")
    fun setSubject() {
        studentRegistrationPage.fillSubject(student.subject)
    }

    @Step("Выбрать хобби случайным образом")
    fun selectRandomHobbies() {
        studentRegistrationPage.selectHobbies(student.hobby)
    }

    @Step("Загрузить фото")
    fun uploadPhoto() {
        studentRegistrationPage.uploadPicture(student.photo)
    }

    @Step("Заполнить поле 'Current Address' случайным значением")
    fun setCurrentAddress() {
        studentRegistrationPage.setCurrentAddress(student.address)
    }

    @Step("Выбрать область и город")
    fun setStateAndCity() {
        studentRegistrationPage.setStateAndCity(student.state, student.city)
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
    fun assertStudentEmail() {
        thanksForSubmittingFormModalWindow.checkTableResponsive(label = "Student Email", value = student.email)
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