package northemquality

import geb.Module

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

class EventCard extends Module {
    final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("d 'de' MMMM yyyy, HH:mm z")
            .toFormatter(new Locale("es", "ES"))

    static content = {
        titleHeader { $('h3') }
        dateEl(required: false) { $('h2', 0) }
        card { $('section') }
        githubLink { $('a', href: contains('github.com'), 0) }
        youtubeLink { $('a', href: contains('youtube.com'), 0) }

    }

    String getGithub() {
        githubLink.getAttribute('href')
    }

    String getYoutube() {
        youtubeLink.getAttribute('href')
    }

    String getAbout() {
        card.text()
                .replace(title, '')
                .replace(dateEl.text(), '')
                .replace(youtubeLink.text(), '')
                .replace(githubLink.text(), '')
    }

    LocalDateTime getDateTime() {
        dateEl.empty ? null : LocalDateTime.parse(dateEl.text(), formatter)
    }

    String getTitle() {
        titleHeader.text()
    }

    Event getEvent() {
        new Event(title: title,
                dateTime: dateTime,
                about: about,
                youtube: youtube,
                github: github)
    }
}
