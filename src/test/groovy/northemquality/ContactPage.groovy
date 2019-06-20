package northemquality

import geb.Page

class ContactPage extends Page {

    static url = '/contacta.html'

    static at = { $('article#main header.container h2', 0).text().equalsIgnoreCase('Contactanos')}

    static content = {
        mainNav(required: false) { $('#nav').module(MainNav) }
        mobileNav(wait: true, required: false) { $('#topPanel').module(MainNav) }
        socialMedia { $('footer#footer ul.icons').module(SocialMediaNav) }
        emailLink { $('a', href: startsWith('mailto')) }
        organizersCards { $('div.row div').moduleList(OrganizerCard) }
        topButton(required: false) { $('#topButton') }
    }

    boolean isMainNavVisible() {
        !mainNav.empty
    }

    boolean isMobileNavVisible() {
        !mobileNav.empty && mobileNav.getAttribute('style').contains("top: 0px;")
    }

    boolean isHamburgerButtonVisible() {
        !topButton.empty
    }

    void openHamburgerNav() {
        topButton.click()
    }

    String getEmail() {
        emailLink.getAttribute('href').substring('mailto:'.length())
    }
    String getDisplayedEmail() {
        emailLink.text()
    }

    int countOrganizers() {
        organizersCards.size()
    }

    List<Organizer> getOrganizers() {
        organizersCards.collect { it.organizer }
    }
}
