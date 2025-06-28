package utils

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selectors.byText

class Calendar {
    fun setDate(day: String, month: String, year: String) {
        `$`(".react-datepicker__year-select").`$`(byText(year)).click()
        `$`(".react-datepicker__month-select").`$`(byText(month)).click()
        `$`(".react-datepicker__day--0$day:not(.react-datepicker__day--outside-month)").click()
    }
}