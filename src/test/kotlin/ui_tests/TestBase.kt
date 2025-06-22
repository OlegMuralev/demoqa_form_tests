package ui_tests

import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.BeforeAll


open class TestBase {
    companion object {
        @JvmStatic
        @BeforeAll
        fun setup(): Unit {
            Configuration.baseUrl = "https://demoqa.com"
            Configuration.browser = "chrome"
        }
    }

}