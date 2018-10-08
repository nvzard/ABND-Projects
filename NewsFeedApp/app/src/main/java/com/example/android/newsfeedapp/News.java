package com.example.android.newsfeedapp;

public class News {

    private String title, section, date, link;

    public News(String title, String section, String date, String link) {
        this.title = title;
        this.section = section;
        this.date = date;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getDate() {
        return date.substring(0, 10);
    }

    public String getLink() {
        return link;
    }
}
