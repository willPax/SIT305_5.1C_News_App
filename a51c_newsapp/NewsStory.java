package com.example.a51c_newsapp;

public class NewsStory {
    private String headline;
    private int body;
    private String publisher;
    private int newsImage;


    public NewsStory(String headline, int body, String publisher, int newsImage) {
        this.headline = headline;
        this.body = body;
        this.publisher = publisher;
        this.newsImage = newsImage;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(int newsImage) {
        this.newsImage = newsImage;
    }
}

