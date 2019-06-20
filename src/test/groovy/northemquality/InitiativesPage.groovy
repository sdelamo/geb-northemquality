package northemquality

import geb.Page

class InitiativesPage extends Page {

    static url = '/iniciativas.html'

    static at = { $('article#main header.container h2', 0).text().equalsIgnoreCase('Nuestras Iniciativas') }

    static content = {
        mainNav { $('#nav').module(MainNav) }
        socialMedia { $('footer#footer ul.icons').module(SocialMediaNav) }
    }
}
