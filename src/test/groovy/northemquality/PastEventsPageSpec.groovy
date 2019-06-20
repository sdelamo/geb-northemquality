package northemquality

import geb.spock.GebReportingSpec

class PastEventsPageSpec extends GebReportingSpec implements ResolutionsFixture {
    void "can retrieve Past Events Page"() {
        when:
        to PastEventsPage

        then:
        waitFor { at PastEventsPage }
    }

    void "social media icons are present in Past events page"() {
        when:
        PastEventsPage page = to PastEventsPage

        then:
        page.socialMedia.twitter == 'https://twitter.com/NorthemQuality'
        page.socialMedia.github == 'https://github.com/NorthemQuality'
        page.socialMedia.slack == 'https://northemquality.slack.com/'
    }

    void "can go to Welcome page with the main Nav"() {
        given:
        maximize()

        when:
        PastEventsPage page = to PastEventsPage
        page.mainNav.welcome()

        then:
        waitFor { at WelcomePage }
    }

    void "can go to Initiatives page with the main Nav"() {
        given:
        maximize()

        when:
        PastEventsPage page = to PastEventsPage
        page.mainNav.initiatives()

        then:
        waitFor { at InitiativesPage }
    }

    void "can go to Contact page with the main Nav"() {
        given:
        maximize()

        when:
        PastEventsPage page = to PastEventsPage
        page.mainNav.contact()

        then:
        waitFor { at ContactPage }
    }

    void "can retrieve past events"() {
        when:
        PastEventsPage page = to PastEventsPage
        List<Event> events = page.events

        then:
        !events.empty
        events.size() > 1

        and: 'events are sorted in reverse chronological order'
        events.first().dateTime.isAfter(events.last().dateTime)
    }
}
