package northemquality

import geb.spock.GebSpec

class InitiativesPageSpec extends GebSpec implements ResolutionsFixture {
    void "can retrieve Initiatives Page"() {

        when:
        to InitiativesPage

        then:
        at InitiativesPage
    }

    void "social media icons are present in Initiatives Page"() {
        when:
        InitiativesPage page = to InitiativesPage

        then:
        page.socialMedia.twitter == 'https://twitter.com/NorthemQuality'
        page.socialMedia.github == 'https://github.com/NorthemQuality'
        page.socialMedia.slack == 'https://northemquality.slack.com/'
    }

    void "can go to Welcome page with the main Nav"() {
        given:
        maximize()

        when:
        InitiativesPage page = to InitiativesPage
        page.mainNav.welcome()

        then:
        at WelcomePage
    }

    void "can go to Past Events page with the main Nav"() {
        given:
        maximize()

        when:
        InitiativesPage page = to InitiativesPage
        page.mainNav.pastEvents()

        then:
        at PastEventsPage
    }

    void "can go to Contact page with the main Nav"() {
        given:
        maximize()

        when:
        InitiativesPage page = to InitiativesPage
        page.mainNav.contact()

        then:
        at ContactPage
    }
}
