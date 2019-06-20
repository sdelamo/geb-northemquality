package northemquality

import geb.Page

class PastEventsPage extends Page {

    static url = '/eventos_pasados.html'

    static at = { $('article#main header.container h2', 0).text().equalsIgnoreCase('Eventos pasados')}

    static content = {
        mainNav { $('#nav').module(MainNav) }
        eventCards { $('.wrapper div div').moduleList(EventCard) }
        socialMedia { $('footer#footer ul.icons').module(SocialMediaNav) }
    }

    List<Event> getEvents() {
        eventCards.collect { it.event }
    }
}
