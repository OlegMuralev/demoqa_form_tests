package steps

class WebStudentRegistrationSteps(
    private val delegate: WebStepsForStudentRegistrationPage
) : StudentRegistrationSteps {

    override fun openForm() = delegate.openStudentRegistrationForm()

    override fun fillAllFields() = delegate.fillAllFieldsInTheForm()

    override fun fillMandatoryFields() = delegate.fillMandatoryFieldsInTheForm()

    override fun submitExpectSuccess() = delegate.clickSubmitButtonAndCheckModalDialogAppears()

    override fun submitExpectValidationError() = delegate.clickSubmitButtonExpectingValidationError()

    override fun fillEmail(email: String) = delegate.fillUserEmail(email)

    override fun verifyEmail(email: String) = delegate.assertStudentEmail(email)

    override fun verifyAllFields() {
        delegate.assertStudentName()
        delegate.assertStudentEmail()
        delegate.assertGender()
        delegate.assertMobilePhone()
        delegate.assertDateOfBirth()
        delegate.assertSubject()
        delegate.assertHobbies()
        delegate.assertPicture()
        delegate.assertStateAndCity()
    }

    override fun closeModal() = delegate.clickCloseButton()
}
