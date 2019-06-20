package northemquality

import geb.Module

class OrganizerCard extends Module {

    static content = {
        image { $('img')}
        nameHeader { $('h3', 0) }
        socialMedia { $('p').module(SocialMediaNav) }
    }

    String getImageRelativePath() {
        image.getAttribute('src')
    }

    String getName() {
        nameHeader.text()
    }

    Organizer getOrganizer() {
        new Organizer(name: name,
                twitter: socialMedia.twitter,
                linkedIn: socialMedia.linkedIn,
                github: socialMedia.github)
    }
}
