package northemquality

import geb.Module

class SocialMediaNav extends Module {

    static content = {
        twitterLink { $('a.fa-twitter', 0) }
        slackLink(required: false) { $('a.fa-slack', 0) }
        linkedInLink(required: false) { $('a.fa-linkedin', 0) }
        githubLink { $('a.fa-github', 0) }
    }

    String getTwitter() {
        twitterLink.getAttribute('href')
    }

    String getSlack() {
        slackLink.empty ? null : slackLink.getAttribute('href')
    }

    String getGithub() {
        githubLink.getAttribute('href')
    }

    String getLinkedIn() {
        linkedInLink.empty ? null : linkedInLink.getAttribute('href')
    }
}
