package northemquality

import geb.Module

class MainNav extends Module {

    static content = {
        welcomeLink { $('a', href: '/', 0) }
        contactLink { $('a', href: ContactPage.url, 0) }
        initiativesLink { $('a', href: InitiativesPage.url, 0) }
        pastEventsLink { $('a', href: PastEventsPage.url, 0) }
    }

    void welcome() {
        welcomeLink.click()
    }

    void contact() {
        contactLink.click()
    }

    void initiatives() {
        initiativesLink.click()
    }

    void pastEvents() {
        pastEventsLink.click()
    }
}
