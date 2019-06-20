package northemquality

import geb.Browser
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.safari.SafariDriver

trait DriverDetector {

    boolean isHtmlUnit() {
        browser.driver instanceof HtmlUnitDriver
    }

    boolean isSafari() {
        browser.driver instanceof SafariDriver
    }

    abstract Browser getBrowser()
}