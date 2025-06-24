package ui_tests

import com.codeborne.selenide.Configuration
import io.github.bonigarcia.wdm.WebDriverManager

import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.chrome.ChromeOptions


open class TestBase {
    companion object {
        @JvmStatic
        @BeforeAll
        fun setup() {
            WebDriverManager.chromedriver()
                .driverVersion("137.0.7151.120")
                .setup()

            Configuration.browser = "chrome"
            Configuration.baseUrl = "https://demoqa.com"
            Configuration.browserCapabilities = ChromeOptions().apply {
                addArguments("--disable-gpu")
                addArguments("--no-sandbox")
                addArguments("--disable-dev-shm-usage")
                addArguments("--remote-allow-origins=*")
                addArguments("--disable-blink-features=AutomationControlled")
                addArguments("--disable-extensions")
                addArguments("--disable-infobars")
            }
            Configuration.browserSize = "1920x1080"
            Configuration.pageLoadStrategy = "eager"

        }
    }

}