package northemquality

import geb.spock.GebReportingSpec

class WelcomePageSpec extends GebReportingSpec implements ResolutionsFixture {

    void "can retrieve Welcome Page"() {
        when:
        to WelcomePage

        then:
        waitFor { at WelcomePage }
    }

    void "social media icons are present in welcome page"() {
        when:
        WelcomePage page = browser.page(WelcomePage)

        then:
        page.socialMedia.twitter == 'https://twitter.com/NorthemQuality'
        page.socialMedia.github == 'https://github.com/NorthemQuality'
        page.socialMedia.slack == 'https://northemquality.slack.com/'
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

    void "can go to Initiatives page with the main Nav"() {
        given:
        maximize()

        when:
        ContactPage page = to ContactPage
        page.mainNav.initiatives()

        then:
        waitFor { at InitiativesPage }
    }

    void "can go to Contact page with the main Nav"() {
        given:
        maximize()

        when:
        ContactPage page = to ContactPage
        page.mainNav.contact()

        then:
        waitFor { at ContactPage }
    }

    void "can go to Past Events page with the main Nav"() {
        when:
        ContactPage page = to ContactPage
        page.mainNav.pastEvents()

        then:
        waitFor { at PastEventsPage }
    }
}
