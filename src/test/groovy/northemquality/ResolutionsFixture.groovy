package northemquality

import geb.Browser
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point

trait ResolutionsFixture {

    abstract Browser getBrowser()

    Dimension IPHONE_8 = new Dimension(375, 677)

    void maximize() {
        browser.driver.manage().window().maximize()
    }

    void setSize(Dimension dimension) {
        browser.driver.manage().window().setSize(dimension)
    }

    void setSize(int width, int height) {
        size = new Dimension(width, height)
    }
}