package com.example.qlangeveld.journal;

import java.io.Serializable;

public class JournalEntry implements Serializable {
    private int id;
    private String title;
    private String content;
    private String mood;
    private int timeStamp;


    public JournalEntry(String title, String content, String mood, int timeStamp) {
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getTimeStamp() {
        return timeStamp;
    }
}
