package fr.xebia.behemoth

class Event {
    String title
    String url
    String description
    Date startDate
    Date endDate
    Venue venue
    String city
    String country
    Float latitude
    Float longitude
    String imageUrl
    List<Performer> performers

    static constraints = {
    }
}
