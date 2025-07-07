package pages

import com.codeborne.selenide.Selenide.`$` as s
import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selectors.byText

class ThanksForSubmittingFormModalWindow {
    private val modalDialog = s(".modal-dialog")
    private val tableResponsive = s(".table-responsive")
    private val closeButton = s("#closeLargeModal")

    fun checkModalDialogAppear() {
        modalDialog.should(appear)
    }

    fun checkTableResponsive(label: String, value: String) {
        tableResponsive.`$`(byText(label)).parent().shouldHave(text(value))
    }

    fun clickCloseButton() {
        closeButton.click()
    }

    fun checkModalDialogDisappear() {
        modalDialog.should(disappear)
    }
}