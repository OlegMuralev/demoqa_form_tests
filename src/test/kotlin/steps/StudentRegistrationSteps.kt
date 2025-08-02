package steps

interface StudentRegistrationSteps {
    fun openForm()
    fun fillAllFields()
    fun fillMandatoryFields()
    fun submitExpectSuccess()
    fun submitExpectValidationError()
    fun fillEmail(email: String)
    fun verifyEmail(email: String)
    fun verifyAllFields()
    fun closeModal()
}