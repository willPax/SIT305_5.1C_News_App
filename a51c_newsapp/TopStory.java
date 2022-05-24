package com.example.a51c_newsapp;

public class TopStory {
    private String newsHeading;
    private int newsBait;
    private String publisher;
    private int image;

    public TopStory(String newsHeading, int newsBait, String publisher, int image) {
        this.newsHeading = newsHeading;
        this.newsBait = newsBait;
        this.publisher = publisher;
        this.image = image;
    }

    public String getNewsHeading() {
        return newsHeading;
    }

    public void setNewsHeading(String newsHeading) {
        this.newsHeading = newsHeading;
    }

    public int getNewsBait() {
        return newsBait;
    }

    public void setNewsBait(int newsBait) {
        this.newsBait = newsBait;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
