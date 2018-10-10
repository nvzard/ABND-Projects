package com.example.android.newsfeedapp;

public class News {

    private String title, section, author, date, link;

    public News(String title, String section, String author, String date, String link) {
        this.title = title;
        this.section = section;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }
}
