package northemquality

import geb.spock.GebSpec
import org.openqa.selenium.Point
import spock.lang.IgnoreIf

class ContactPageSpec extends GebSpec implements ResolutionsFixture, DriverDetector {

    void "can retrieve Contact Page"() {
        when:
        to ContactPage

        then:
        waitFor { at ContactPage }
    }

    void "social media icons with links are present in contact page"() {
        when:
        ContactPage page = to ContactPage

        then:
        page.socialMedia.twitter == 'https://twitter.com/NorthemQuality'
        page.socialMedia.github == 'https://github.com/NorthemQuality'
        page.socialMedia.slack == 'https://northemquality.slack.com/'
    }

    void "email is present in Contact Page"() {
        when:
        ContactPage page = to ContactPage

        then:
        page.email == 'northemquality.info@gmail.com'
        page.displayedEmail == 'northemquality.info@gmail.com'
    }

    void "organizers are displayed"() {
        given:

        String franciscoName = isHtmlUnit() || isSafari() ? 'Francisco Moreno' : 'Francisco Moreno'.toUpperCase()
        Organizer francisco = new Organizer(name: franciscoName,
                twitter: "https://twitter.com/morvader",
                linkedIn: "https://www.linkedin.com/in/franciscomorenosanz/",
                github: "https://github.com/morvader")
        String aritzName = isHtmlUnit() || isSafari() ? 'Aritz Águila' : 'Aritz Águila'.toUpperCase()
        Organizer artitz = new Organizer(name: aritzName,
                twitter: 'https://twitter.com/duiraritz',
                github: 'https://github.com/aaguila',
                linkedIn: 'https://www.linkedin.com/in/aritz-aguila-diaz/')

        when:
        ContactPage page = to ContactPage

        then:
        page.countOrganizers() == 2

        when:
        List<Organizer> organizers = page.organizers

        then:
        organizers.contains(francisco)
        organizers.contains(artitz)
    }

    void "can go to Welcome page with the main Nav"() {
        given:
        maximize()

        when:
        ContactPage page = to ContactPage
        page.mainNav.welcome()

        then:
        waitFor { at WelcomePage }
    }

    void "can go to Past Events page with the main Nav"() {
        given:
        maximize()

        when:
        ContactPage page = to ContactPage

        then:
        waitFor {
            page.isMainNavVisible()
        }

        when:
        page.mainNav.pastEvents()

        then:
        waitFor { at PastEventsPage }
    }

    void "can go to Initiatives page with the main Nav"() {
        given:
        maximize()

        when:
        ContactPage page = to ContactPage
        page.mainNav.initiatives()

        then:
        waitFor { at InitiativesPage }
    }

    @IgnoreIf({ !System.getProperty('geb.env') ||
            System.getProperty('geb.env') == 'htmlUnit' ||
            System.getProperty('geb.env') == 'chromeHeadless' })
    void "can go to Initiatives page with the hamburger Menu"() {
        given:
        size = IPHONE_8

        when:
        ContactPage page = to ContactPage

        then:
        page.isHamburgerButtonVisible()

        when:
        page.openHamburgerNav()

        then:
        waitFor { page.isMobileNavVisible()}

        when:
        page.mobileNav.initiatives()

        then:
        waitFor { at InitiativesPage }
    }
}
