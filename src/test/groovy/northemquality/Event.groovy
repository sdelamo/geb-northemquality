package northemquality

import groovy.transform.ToString

import java.time.LocalDateTime

@ToString(excludes = ['about', 'youtube', 'github'])
class Event {
    String title
    LocalDateTime dateTime
    String about
    String youtube
    String github
}
