package northemquality

import geb.Page

class WelcomePage extends Page {

    static url = '/index.html'

    static at = {
        $('article#main header.container h2', 0).text()
                .replaceAll(" +", " ")
                .replaceAll("\n", "")
                .replaceAll("\t", "")
                .trim()
                .equalsIgnoreCase('Una comunidad Online de testing e ingeniería!')
    }

    static content = {
        mainNav { $('#nav').module(MainNav) }
        socialMedia { $('footer#footer ul.icons').module(SocialMediaNav) }
    }

}
